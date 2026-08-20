package ex0807.overriding.goods;

/**
 * 상품으로 속성을 관리하는 개체
 */
public class Goods {
	private String code; // 상품코드 null
	private String name;// 상품이름 null
	private int price;// 가격 0
	private String explain;// 설명 null

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", explain=");
		builder.append(explain);
		builder.append("]");

		return builder.toString();
	}

//	@Override
//	public String toString() {
//		// String은 값을 변경할 수 없기 때문에 이렇게 하는 것은 나쁜 코드
//		// return code + " | " + name + " | " + price + " | " + explain;
//		
//		// 문자열 값을 변경할때는 StringBuilder를 사용한다
//		StringBuilder sb = new StringBuilder();
//		
//	}

}