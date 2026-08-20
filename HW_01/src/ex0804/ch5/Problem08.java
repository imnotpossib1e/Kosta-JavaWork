package ex0804.ch5;

public class Problem08 {
	public static void main(String[] args) {
		int[][] array= {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int row = array.length;
		
		int sum = 0;
		int cnt = 0;
		
//		for(int i = 0; i<row; i++) {
//			for(int j = 0; j<array[i].length; j++) {
//				sum += array[i][j];
//				cnt++;
//			}
//		}
		
		for(int[] is: array) {
			for(int i: is) {
				sum+=i;
				cnt++;
			}
		}
		
		
		double avg = sum / (double)cnt;
		System.out.printf("총점: %d, 평균: %.2f", sum, avg);
	}

}
