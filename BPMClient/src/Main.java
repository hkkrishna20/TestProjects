import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static int[] arr = { 12, 15, 16, 17, 19 };
	private static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter key size");
		int key = sc.nextInt();
		if (key >= 0) {
			normalorder(key);
		} else {
			reverseOrder(key);
		}
		System.out.println(list);
	}

	public static int[] getArr() {
		return arr;
	}

	public static void setArr(int[] arr) {
		Main.arr = arr;
	}

	public static List<Integer> getList() {
		return list;
	}

	public static void setList(List<Integer> list) {
		Main.list = list;
	}

	public static void normalorder(int key) {
		for (int i = 0; i < arr.length; i++) {
			int pos = i + 1;
			int sum = 0;
			for (int j = 0; j < key; j++) {
				if ((pos + j) < arr.length) {
					sum =sum+arr[pos + j];
				}
				else {
					sum =sum+arr[pos + j-arr.length];
				}
			}
			list.add(sum);

		}
	}

	public static void reverseOrder(int key) {
		Integer[] intArray = new Integer[arr.length]; 
		for (int i = arr.length-1; i >= 0; i--) {
			int pos = i - 1;
			int sum = 0;
			for (int j = 0; j < Math.abs(key); j++) {
				if ((pos - j) >= 0) {
					sum =sum+arr[pos - j];
				}
				else {
					sum =sum+arr[pos - j+arr.length];
				}
			}
			intArray[i] = sum;
		}
		list = Arrays.asList(intArray);
	}
}
