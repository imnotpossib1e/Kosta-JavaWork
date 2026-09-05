package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kosta.db.dto.EmpDTO;
import kosta.db.util.DbManager;

public class EmpDAO {

    /**
     * emp 테이블에서 사원의 모든 이름 검색
     */
    public void selectNames() {
        // 로드 연결 실행 닫기

        // try 밖에서 미리 선언
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DbManager.getConnection(); // 연결
            st = con.createStatement();
            rs = st.executeQuery("select ename from emp");

            // 앞으로 커서가 이동할 수 있을 동안 반복
            while (rs.next()) { // 앞으로 커서가 이동한다면
                // 열 조회
                String ename = rs.getString("ename");
                System.out.println(ename);
            }
            System.out.println("**완료**");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, st, rs);
        }
    }

    /**
     * 사원번호에 해당하는 레코드 삭제
     * 원래는 void 아니고 리턴해줘야한다.
     */
    public void deleteByEmpno(int empno) { // 1000 or 1=1 넣으면 보인 취약(SqlInjection)
        Connection con = null;
        Statement st = null;
        // 보안에 취약한 방법
        String sql = "delete from emp where empno=" + empno;
        try {
            con = DbManager.getConnection();
            st = con.createStatement();
            int re = st.executeUpdate(sql);
            if (re == 0) {
                System.out.println("삭제되지 않았습니다.");
            } else {
                System.out.println("삭제되었습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, st);
        }
    }

    // 위 Delete를 PreparedStatement 방식으로 변경
    public void deleteByEmpno2(int empno) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from emp where empno=?";
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);

            // ? 개수만큼 순서대로 setType(index, value) 설정 필수
            ps.setInt(1, empno);

            // 실행 요청
            int re = ps.executeUpdate();
            if (re == 0) {
                System.out.println("삭제되지 않았습니다.");
            } else {
                System.out.println("삭제되었습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, ps);
        }
    }

    /**
     * 모든 사원의 정보 검색하기
     * select empno, ename, job, sal, hiredate from emp;
     * -> 전체 테이블 반환
     */
    public List<EmpDTO> selectAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 쿼리문
        String sql = "select empno, ename, job, sal, hiredate from emp";
        // 리턴 타입 세팅
        List<EmpDTO> list = new ArrayList<EmpDTO>();

        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int sal = rs.getInt("sal");
                String hiredate = rs.getString("hiredate");
                EmpDTO emp = new EmpDTO(empno, ename, job, sal, hiredate);
                list.add(emp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DbManager.dbClose(con, ps, rs);
        }
        return list;
    }

    /**
     * 사원번호에 해당하는 사원정보 검색하기
     * select empno, ename, job, sal, hiredate from emp where empno = ?;
     * -> 레코드 하나 반환
     */
    public EmpDTO selectByEmpno(int empno) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 쿼리문
        String sql = "select empno, ename, job, sal, hiredate from emp where empno = ?";
        // 리턴 타입 세팅
        EmpDTO empDto = null;
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, empno);
            rs = ps.executeQuery();

            // 하나의 레코드만 가져오기 때문에
            // 커서가 내려가지면 끝나도록 if문
            if (rs.next()) {
                empDto = new EmpDTO(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"),
                                    rs.getInt("sal"), rs.getString("hiredate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, ps, rs);
        }
        return empDto;
    }

    /**
     * 사원 정보 추가하기(등록)
     * insert into emp(empno, ename, job, sal, hiredate) values(?, ?, ?, ?, ?);
     */
    public int insertEmp(EmpDTO empDTO) {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "insert into emp(empno, ename, job, sal, hiredate) values(?, ?, ?, ?, now())";
        int re = 0;
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, empDTO.getEmpNO());
            ps.setString(2, empDTO.geteName());
            ps.setString(3, empDTO.getJob());
            ps.setInt(4, empDTO.getSal());

            re = ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DbManager.dbClose(con, ps);
        }
        return re;
    }
}
