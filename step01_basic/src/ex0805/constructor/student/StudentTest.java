package ex0805.constructor.student;

public class StudentTest {
	public static void main(String[] args) {
		String data [][] = {
				{"김0", "20", "서울"},
				{"이0", "23", "경기"},
				{"박0", "25", "인천"}
		};
		
		System.out.println("***학생 관리 프로그램 시작합니다.******");
		// StudentService의 전역변수들이 초기화 
		StudentService service = new StudentService(data);
		
		// 전체학생정보 호출
		 Student[] stArr = service.selectAll();
		 // 출력
		 EndView.printSelectAll(stArr);
		
		// 등록하기
		System.out.println("--1. 등록하기 -----");
		Student student = new Student("미미", 25, "오리역");
		
		int re = service.insert(student);
		if(re == -1) {
			EndView.printMessage("더이상 등록할 수 없습니다.");
		}else if(re == 0) {
			EndView.printMessage("중복된 정보입니다.");
		}else {
			EndView.printMessage("등록되었습니다.");
		}
		
		
		 System.out.println("--2. 전체검색 -----");
		 // 호출과 출력 한줄로
		 EndView.printSelectAll(service.selectAll());
		
		 // 이름으로 검색하기
		 System.out.println("--3. 이름으로 검색 -----");
		 Student st = service.selectByName("김0");
		 if(st == null) {
			 EndView.printMessage("해당하는 정보가 없습니다.");
		 }else {
			 EndView.printSelectByName(st);
		 }
		
		// System.out.println("--이름이 없는경우----");
		 st = service.selectByName("삼순이");
		 if(st == null) {
			 EndView.printMessage("해당하는 정보가 없습니다.");
		 }else {
			 EndView.printSelectByName(st);
		 }
		
		// 수정하기 
		System.out.println("--4. 수정하기 -----");
		Student st2 =new Student("김0", "대전");

		if(service.update(st2)) {
			EndView.printMessage("수정되었습니다.");
		}else {
			EndView.printMessage("수정할 수 없습니다.");
		}
		
		
		System.out.println("---변경후 ---");
		EndView.printSelectAll(service.selectAll());

	} 

}








