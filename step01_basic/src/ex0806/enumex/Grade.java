package ex0806.enumex;

/**
 * enum: 열거형으로 안에 정의된 정보는 static final로 본다. = 상수이다
 */
public enum Grade {
	// 여러개의 정보를 담고싶을 떄
	BASIC("일반", 200, 5), 
	SILVER("우수", 100, 10), 
	GOLD("최우수", 50, 20); 
	
	// 모두 상수이기때문에 final
	private final String kind;
	private final int point;
	private final int role;
	
	// enum 타입 안에 있는 생성자는 무조건 자동으로 private
	Grade(String kind, int point, int role){
		this.kind=kind;
		this.point=point;
		this.role = role;
	}

	public String getKind() {
		return kind;
	}

	public int getPoint() {
		return point;
	}

	public int getRole() {
		return role;
	}
}

