package algorismProject1;
import java.util.Scanner;
public class algorismProject1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("학생 " + (i+1) + " 점수 입력 : ");
			arr[i] = sc.nextInt();
		}

		quickSort(arr,0,arr.length-1);
		System.out.println();
		System.out.println("성적 순으로 정렬");
		for (int i = 0; i <arr.length; i++) {
			System.out.println((i+1)+"등 : " + arr[i]);
		}
	}
	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = start; 
		int left = start+1;
		int right=end;
		while(left<=right) {
			while(left<=end&&arr[left]>=arr[pivot]) {
				left++; 
			}
			while(right>start&&arr[right]<=arr[pivot]) {
				right--; 
			}
			
			if(left>right) {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			}else {
				int temp = arr[left];
				arr[left]= arr[right];
				arr[right]=temp;
			}
			
			
		}
		quickSort(arr, start, right-1);
		quickSort(arr, right+1,end);
	}
}