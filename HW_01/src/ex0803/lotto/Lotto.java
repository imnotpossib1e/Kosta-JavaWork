package ex0803.lotto;

class LottoSet{
	int cnt;
	int lotto[] = new int[6];
	public void lottoNumSet() {
		// 배열에 집어넣기 전에 중복 체크
		int len = lotto.length;
		while(cnt<len) {
			int lottoNo = (int)(Math.random()*45)+1;
			// 중복이 아닐 때 배열에 넣는다
			if(this.isCompareNo(lottoNo)) {
				lotto[cnt] = lottoNo;
				cnt++;
			}
		}
		System.out.println("로또 번호 뽑기 완료");
	}
	
	// 번호 비교 
	public boolean isCompareNo(int lottoNo) {
		for(int i = 0; i<cnt; i++) {			
			if(lotto[i] == lottoNo) {
				return false; // 중복
			}
		}
		return true; // 중복이 아니다
	}
	
	public void printLotto() {
		System.out.println("로또 번호 출력");
		for(int i: lotto) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void sortLotto() {
		for(int i = 0; i<6-1; i++) {
			for(int j = 0; j<6 - 1-i; j++) {
				if(lotto[j] < lotto[j+1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
			}
		}
		
		System.out.println("로또 번호 정렬 완료");
	}
}

public class Lotto {

	public static void main(String[] args) {
		System.out.println("로또 번호 뽑는중 ...");
		LottoSet ls = new LottoSet();
		
		ls.lottoNumSet();
		ls.printLotto();
		ls.sortLotto();
		ls.printLotto();
		
		
		

	}

}
