package ex0805.constructor.goods;
/**
  각 요청에 대한 로직(기능)을 담당할 클래스
  (등록 , 전체검색, 부분검색, 수정, 삭제 등등.....)
*/
public class GoodsService{

	// 상품을 관리할 배열 선언
	private Goods [] goodsArr = new Goods [6];
	public static int count; // 0 배열방에 저장 객체의 개수 



	/**
	 * 초기치 데이터를 세팅하는 생성자
	 * String [][] data = new String [][]{
	 * 		{"A01" , "새우깡" , "2500" , "짜고 맛나다."},  //---> Goods 
	 * 		{"A02" , "고구마깡" , "3500" , "고구맛이고 달다."},  //---> Goods
	 * 		{"A03" , "감자깡" , "5000" , "감자맛에 고소한맛."}, // ---> Goods 
	 * 		{"A04" , "허니버터칩" , "2200" , "달콤 하다."},
	 * 		{"A05" , "콘칩" , "3000" , "고소하다."}
	 * };
	 */
	public GoodsService(String[][] data) {
		int len = data.length;
		for(int i = 0; i<len; i++) {
			goodsArr[count++] = this.create(data[i]);
		}
	}


	/**
	 * Goods를 생성해서 값을 설정하고 생성된 Goos를 리턴하는 메소드 
	 */
	private Goods create(String [] row){//{"A01" , "새우깡" , "2500" , "짜고 맛나다."}
		Goods goods= new Goods(row[0], row[1], Integer.parseInt(row[2]), row[3]);

		return goods;
	}



	/**
    	등록(등록실패 - 중복인경우, 배열의 길이 벗어난경우)
		@return : 
			 0이면 상품코드 중복 ,
			 1이면 등록성공, 
			 -1이면 배열의 길이 벗어남
   */
   public int insert(Goods goods){
	   // 배열의 길이 체크
	   if(count == goodsArr.length) return -1;

	   // .0중복체크 
	   if(this.selectByCode(goods.getCode()) != null) return 0;
	  
	   // 등록
	   goodsArr[count++] = goods;
	   return 1; 
   }


   /**
     전체검색
   */
   public Goods[]  selectAll( ){
      return goodsArr; // 주소값
   }

   /**
     상품코드에 해당하는 상품 검색
	 @return : 만약 code에 해당하는 값이 있으면 Goods를 리턴하고
	           없으면 null 리턴
   */
   public Goods selectByCode(String code){
       for(int i = 0; i<count; i++) {
    	   // Java는 영어 대소문자를 완벽히 구분한다
    	   // 대소문자 구분 없이 검색하기 위해 비교문자들을 대문자로 바꾼다
    	   if(goodsArr[i].getCode().toUpperCase().equals(code.toUpperCase())) {
    		   return goodsArr[i];
    	   }
       }
       
       // 상품 코드에 해당하는 상품을 찾지 못함
       return null;
   }


   /**
    상품코드에 해당하는 가격, 설명 수정하기 
	@return : true이면 수정완료, false이면 수정실패
   */
   public boolean update(Goods goods){ //수정하려는 코드, 변경값 - 가격, 설명
	   Goods searchgd = this.selectByCode(goods.getCode());
	   
	   // 해당하는 코드 없음
	   if(searchgd == null) return  false;
	   
	   // 수정
	   searchgd.setPrice(goods.getPrice());
	   searchgd.setExplain(goods.getExplain());
      
       return true;
   }
   
   public int findLocate(String code) {
	   for(int i = 0; i<count; i++) {
		   if(goodsArr[i].getCode().equals(code)){
			   return i;
		   }
	   }
	   return -1;
   }
   
   
   /**
    * 삭제
    * @return : true이면 삭제완료, false이면 삭제실패
    */
   public int delete(String code) {
	   // 1. 삭제하려는 상품 코드가 있는 객체가 몇번에 있는지 찾는다 -> index
	   int locate = this.findLocate(code);
	   
	   // 삭제하려는 상품 코드가 없을 떄
	   if(locate == -1) return -1;
	   
	   // 2. 찾은 index 번을 null 변경 -> 해당 인덱스의 객체 GC 일어나 메모리에서 사라진다
	   if(locate >= 0) {
		   goodsArr[locate] = null;
	   }
	   
	   // 3. 삭제된 위치 뒤에있는 각 배열의 주소를 앞으로 이동
	   for(int i = locate; i<count; i++) {
		   goodsArr[locate] = goodsArr[locate+1];
	   }
	   
	   // 4. count 감소
	   count--;
	   
	   return 0;
   }
}