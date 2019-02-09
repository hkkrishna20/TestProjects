package com.practiseclass;

import java.io.IOException;
import java.util.Scanner;

public class PractiseClass {

	public static boolean print2D(int mat[][], int number) {
		int arr[] = mat[0];
		int column = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[0] > number) {
				return false;
			} else if (arr[i] == number) {
				System.out.println("Found at Column : " + i + "Row : " + 0);
				return true;
			} else {

				if (arr[i] < number && ((i + 1) < arr.length) && arr[i + 1] > number) {
					column = i;
					break;
				}
			}
		}
		for (int i = 1; i < mat.length; i++) {
			if (mat[i][column] == number) {
				System.out.println("Found at Row : " + i + "Column : " + column);
				return true;
			}
		}
		System.out.println("Not Found");
		return false;
	}

	public static void main(String args[]) throws IOException {
		int mat[][] = { { 1, 5, 9, 13 }, { 2, 6, 10, 14 }, { 3, 7, 11, 15 }, { 4, 8, 12, 16 } };

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int size = sc.nextInt();

		//System.out.println(print2D(mat, size));
		
		int mat2[][] = { { 1, 1, 1, 9 }, { 2, 6, 10, 14 }, { 3, 7, 11, 15 }, { 4, 8, 12, 16 } };

	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * Scanner sc = new Scanner(System.in); System.out.println("Enter Number"); int
	 * size = sc.nextInt(); int f1 = 0; int f2 = 1; int call=0; callFibonacci(f1,
	 * f2,size,call);
	 * 
	 * System.out.println();
	 * 
	 * for(int i = 0;i<size;i++) { int temp=0; if(size==1) { System.out.println(1);
	 * break; } else if(size==2) { System.out.println(1); break; } else {
	 * System.out.print(f1+" "); temp =f1+f2; f1=f2; f2=temp; }
	 * 
	 * 
	 * }
	 * 
	 */ private static String callFibonacci(int f1, int f2, int size, int call) {
		// TODO Auto-generated method stub
		if (call < size) {
			if (size == 1 || size == 2) {
				System.out.println(f1);
			} else {
				System.out.print(f1 + " ");
				int temp = f1 + f2;
				f1 = f2;
				f2 = temp;
				call++;
				callFibonacci(f1, f2, size, call);
			}

		}
		return "";

	}

}
