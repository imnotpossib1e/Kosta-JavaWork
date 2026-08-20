package ex0803.ch05;

public class Problem07 {

	public static void main(String[] args) {
		int[] array = {1, 5, 3, 8, 2};
		
		// 최대값 출력 - for문
//		int max = 0;
		int max = Integer.MIN_VALUE;
		int len = array.length;
		
		for(int i = 0; i<len; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		
		System.out.println("최댓값: " + max);

	}

}
