package Lab1;

import java.util.Random;
import java.util.*;

public class ClassOfAll {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] a = new int[Integer.parseInt(args[0])];
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(Integer.parseInt(args[1]));
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		/*
		 * 
		 * 
		 *
		 * 
		 * 
		 * 
		 */
		int c = 0;
		for (int i = 0;i<a.length-1;i++) {
			if (a[i] < a[i+1]){
				c = 0;
			}
		}
			for (int i = 0;i<a.length-1;i++) {
			if (a[i] > a[i + 1]) {
				c = 1;
			}
		}
		if (c == 0) {
			System.out.println("- ������ �������� ���������������");
		}
		if (c == 1) {
			System.out.println("- ������ �� �������� ���������������");//isprav

			/*
			 * 
			 *
			 * 
			 * 
			 * 
			 */

		}
		int[] minArray = new int[a.length];
		for (int i = 0; i < minArray.length; i++) {
			minArray[i] = -1;
		}
		int[] maxArray = new int[a.length];
		for (int i = 0; i < maxArray.length; i++) {
			maxArray[i] = -1;
		}
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		int maxIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == max) {
				maxIndex = i;
				maxArray[i] = i;// maxArray = { -1, -1 ,-1 ,-1 , 2, 3}
			}
			if (maxArray[i] >= 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		int min = max;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		int minIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == min) {
				minIndex = i;
				minArray[i] = i;
			}
			if (minArray[i] >= 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("- ������(�) ����������� ��������");
		System.out.println("������������ �������� : " + max + ", " + "����������� �������� : " + min);

	}

}
