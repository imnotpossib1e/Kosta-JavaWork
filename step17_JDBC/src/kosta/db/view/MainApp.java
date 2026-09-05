package kosta.db.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import kosta.db.dao.EmpDAO;
import kosta.db.dto.EmpDTO;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("** JDBC 시작하기 **");
        EmpDAO dao = new EmpDAO();
//        dao.selectNames();
//        System.out.println("***삭제***");
//        dao.deleteByEmpno(7499);

//        dao.deleteByEmpno2(7698);

        System.out.println("***전체출력***");
        List<EmpDTO> list = dao.selectAll();
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("***사원 하나 출력***");
        EmpDTO emp = dao.selectByEmpno(7900);
        if (emp == null) {
            System.out.println("검색된 정보가 없습니다.");
        } else {
            System.out.println(emp);
        }

        System.out.println("***사원 추가***");
        int result = dao.insertEmp(new EmpDTO(12344, "이름", "직업", 3000, null));
        if (result == 0) {
            System.out.println(result + " => 등록에 실패했습니다.");
        } else {
            System.out.println(result + " => 등록되었습니다.");
        }


    }

}
