package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import kosta.db.util.DbManager;


public class TransactionDAO {

    /**
     * 계좌이체 기능 구현
     * 출금 -> 입금 -> 잔액 조회 메소드를 각각 따로 뺀다.
     *
     * 세개의 메소드가 하나의 connection을 공유해야한다.
     */
    public void transfer(String inputAccount, String outputAccount, int money) {
        // 로드 연결 실행 닫기

        Connection con = null;

        try {
            con = DbManager.getConnection(); // 기본으로 auto commit된다.
            con.setAutoCommit(false); // auto commit 끄기

            // 출금하기
            int result = this.withdraw(con, outputAccount, money);

            if (result == 0) { // 출금 실패
                throw new SQLException("출금 계좌번호 오류로 계좌이체 실패했습니다.");
            }

            // 입금하기
            result = this.deposit(con, inputAccount, money);
            if (result == 0) {
                throw new SQLException("입금 계좌번호 오류로 계좌이체 실패했습니다.");
            }

            // 잔액조회
            if (this.balanceCheck(con, inputAccount)) {
                throw new SQLException("입금계좌 잔액 초과로 계좌이체 실패");
            }

            // 모두 성공
            System.out.println("계좌이체에 성공하셨습니다.");
            con.commit();
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());

            try {
                con.rollback(); // 롤백하기
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } finally {
            DbManager.dbClose(con, null);
        }
    }

    /**
     * 출금
     * update bank set balance=balane-인출금액 where account = 출금계좌번호
     */
    public int withdraw(Connection con, String outputAccount, int money) throws SQLException {
        PreparedStatement ps = null;
        String sql = "update bank set balance=balance-? where account = ?";
        int result = 0;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, money);
            ps.setString(2, outputAccount);

            result = ps.executeUpdate();
        } finally {
            DbManager.dbClose(null, ps);
        }
        return result;
    }

    /**
     * 입금
     * update bank set balance=balance+인출금액 where account =입금계좌번호
     */
    public int deposit(Connection con, String inputAccount, int money) throws SQLException {
        PreparedStatement ps = null;
        String sql = "update bank set balance=balance+? where account =?";
        int result = 0;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, money);
            ps.setString(2, inputAccount);

            result = ps.executeUpdate();
        } finally {
            DbManager.dbClose(null, ps);
        }
        return result;
    }

    /**
     * 잔액조회 -> 천억 벗어났는지 안벗어났는지 확인용
     * select balance from bank where account = ?
     *
     * @return: boolean
     * true: 잔액 초과 , false: 잔액 초과 X
     */
    public boolean balanceCheck(Connection con, String inputAccount) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "select balance from bank where account = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, inputAccount);
            rs = ps.executeQuery();

            if (rs.next()) {
                int balance = rs.getInt(1);
                if (balance >= 1000) {
                    result = true;
                }
            }

        } finally {
            DbManager.dbClose(null, ps, rs);
        }
        return result;
    }

    public static void main(String[] args) {
        TransactionDAO dao = new TransactionDAO();
        System.out.println("--1. 출금계좌 오류----");
//        dao.transfer("A02", "A05", 200);//입금, 출금, 금액

        System.out.println("--2. 입금계좌 오류----");
//        dao.transfer("A04", "A01", 200);//입금, 출금, 금액

        System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
//        dao.transfer("A02", "A01", 700);//입금, 출금, 금액

        System.out.println("--4. 성공----------");
        dao.transfer("A02", "A01", 100);//입금, 출금, 금액
    }
}











