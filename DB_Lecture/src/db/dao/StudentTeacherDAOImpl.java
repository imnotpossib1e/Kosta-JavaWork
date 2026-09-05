package db.dao;

import db.util.DbManager;
import db.vo.Room;
import db.vo.Student;
import db.vo.Subject;
import db.vo.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {

    /**
     * 1번 : 성별이 여자인 학생의 정보 검색
     * select * from student where  수_주민등록번호 like '%-2%'
     *
     */
    @Override
    public List<Student> getGenderByWomen() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from student where  수_주민등록번호 like '%-2%'";
        List<Student> list = new ArrayList<Student>();

        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(
                    new Student(rs.getInt("수강생번호"), rs.getString("수_이름"), rs.getString("수_주민등록번호"),
                                rs.getString("수_연락처"), rs.getString("수_주소"),
                                rs.getString("수_이메일")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, ps, rs);
        }
        return list;
    }

    /**
     * 3.  "구"를 인수로 전달받아 구에 거주하는 강사의 정보 검색
     * select * from teacher  where 주소 like ?
     *
     * @param gu
     *
     */
    @Override
    public List<Teacher> getTeacherInfoByAddr(String gu) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from teacher  where 주소 like ?";
        List<Teacher> list = new ArrayList<Teacher>();

        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + gu + "구%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(
                    new Teacher(rs.getInt("강사번호"), rs.getString("강사이름"), rs.getString("주민등록번호"),
                                rs.getString("연락처"), rs.getString("주소"),
                                rs.getString("이메일"), rs.getString("수강코드")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, ps, rs);
        }
        return list;
    }

    /**
     * 5. 과목을 인수로 전달받아 그 과목을 강의하는 강사의 정보 (서브쿼리)
     * select * from teacher where 수강코드 =
     * (select 수강코드 from subject where upper(과목)=upper( ? ))
     *
     * @param subject
     *
     */
    @Override
    public Teacher getTeacherInfoBySubject(String subject) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from teacher where 수강코드 = (select 수강코드 from subject where upper(과목)=upper( ? ))";

        Teacher teacher = null;
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, subject);
            rs = ps.executeQuery();
            if (rs.next()) {
                teacher = new Teacher(rs.getInt("강사번호"), rs.getString("강사이름"),
                                      rs.getString("주민등록번호"),
                                      rs.getString("연락처"), rs.getString("주소"),
                                      rs.getString("이메일"), rs.getString("수강코드"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, ps, rs);
        }
        return teacher;
    }

    /**
     * 8강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다
     * select * from v_teacherInfo  where 강사번호=?
     *
     * @param teacherNo
     *
     *
     */
    @Override
    public Teacher getTeacherInfoByNo(int teacherNo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from v_tear  where 강사번호=?";
        Teacher teacher = null;

        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, teacherNo);
            rs = ps.executeQuery();

            while (rs.next()) {
                teacher = new Teacher();
                teacher.setTeacherNo(rs.getInt("강사번호"));
                teacher.setTeacherName(rs.getString("강사이름"));
                
                teacher.setSubject(new Subject(rs.getString("수강코드"), rs.getString("과목")));

                teacher.setRoom(new Room(rs.getInt("강의실번호"), rs.getInt("수강인원")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.dbClose(con, ps, rs);
        }

        return teacher;
    }
}
