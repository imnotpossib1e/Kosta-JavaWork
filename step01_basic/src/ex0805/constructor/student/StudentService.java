package ex0805.constructor.student;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
	private Student stArr[] = new Student[5];
	
	// 배열에 저장된 객체의 개수를 저장하는 변수(공유 변수)
	public static int cnt = 0;
	
	
	/**
	 * 생성자
	 * 초기치데이터 3명 정도 세팅하기 
	 * */
	public StudentService(String[][] data) {
		int len = data.length;
		for(int i = 0; i<len; i++) {
			stArr[cnt++] = this.createSt(data[i]);		
		}
	}
	

	/**
	 *  Student 객체를 생성해서 리턴해주는 메소드 작성
	 * */
	private Student createSt(String[] row) {
		// 생성자 생성과 동시에 값을 입력
		Student st = new Student(row[0], Integer.parseInt(row[1]), row[2]);
		
		return st;
	}
	

	 /**
	   학생의 정보 등록하기 
	    : 학생의 이름이 중복이면 등록할 수 없다.
	    : 배열의 경계를 벗어나면 더이상 추가할수 없습니다.
	    : 이 외에는 추가를한다
	    
	    @return : int
	    			0: 중복, -1: 더이상 등록 불가, 1: 성공
	  **/
	public int insert(Student student) {
		// 배열 경계를 벗어난 경우
		if(cnt == stArr.length) return -1; 
		
		// 학생의 이름이 중복인 경우
		Student searchedStudent = this.selectByName(student.getName());
		if(searchedStudent != null) return 0;
		
		// 등록
		stArr[cnt++] = student;
		return 1; // 성공
	}
	 
	 
	
	/**
	 * 전체 학생의 정보 조회하기
	 * */
	public Student[] selectAll() {
		return stArr;
	}
	 
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를출력하고
	 *     없으면 null 리턴
	 * */
	public Student selectByName(String name) {
		for(int i = 0; i<cnt; i++) {
			if(stArr[i].getName().equals(name)) {
				// 이름 해당하는 정보가 있다면
				 return stArr[i];
			}
		}
		
		// 이름 해당하는 정보가 없음
		return null;
	}
	
	
	
	/**
	 * 이름에 해당하는 학생의 주소 변경하기 
	 *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 "수정할수 없습니다." 출력
	 *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고
	 *   "수정되었습니다" 출력
	 *   @param : Student
	 *   @return : boolean
	 *   			false: 수정 실패, true: 수정 성공
	 * */
	public boolean update(Student st) {
		// 해당하는 학생 찾기
		Student searchSt = this.selectByName(st.getName());
		
		// 해당하는 학생 없음
		if(searchSt == null) return false;
		 
		// 수정
//		searchSt.setAge(st.getAge());
		searchSt.setAddr(st.getAddr());
		
		return true; 
	}
}

