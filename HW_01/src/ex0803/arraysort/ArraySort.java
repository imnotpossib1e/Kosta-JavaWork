package ex0803.arraysort;

public class ArraySort {

	public static void main(String[] args) {
		int arr[] = {5, 7, 1, 2, 4, 3, 8, 9, 6, 10};
		
		int len = arr.length;
		
		// 버블 정렬
		for(int i = 0; i<len-1; i++) {
			for(int j = 0; j<len -1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("버블정렬");
		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 삽입 정렬
		
		// 재정의
		int arr2[] = {1, 7, 5, 2, 4, 3, 8, 9, 6, 10};
		int len2 = arr.length;
		for(int i = 1; i<len2; i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr2[j] > key) {
				arr2[j+1] = arr2[j];
				j--;
			}
			arr2[j+1] = key;
			
		}
		System.out.println("삽입정렬");
		for(int i: arr2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 선택정렬
		int arr3[] = {5, 7, 1, 2, 4, 3, 8, 9, 6, 10};
		int len3 = arr3.length;
		
		for(int i = 0; i<len3 -1; i++) {
			int min = i;
			
			for(int j = i+1; j<len3; j++) {
				if(arr3[j]<arr3[min]) {
					min = j;
				}
			}
			
			int temp = arr3[i];
			arr3[i] = arr3[min];
			arr3[min] = temp;
		}
		
		System.out.println("선택정렬");
		for(int i: arr3) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		
	}

}
