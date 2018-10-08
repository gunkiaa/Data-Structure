package sort;

import java.util.ArrayList;

/**
 * @author kimgun
 * @date 2018.10.08
 */
public class BubbleSort {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(1);
		list.add(5);
		list.add(9);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(7);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println("");

		System.out.println("******************** 버블 정렬 *********************");
		System.out.println("======================오름차순======================");
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) > list.get(j + 1)) {
					int temp = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, temp);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println();

		System.out.println("======================내림차순======================");
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) < list.get(j + 1)) {
					int temp = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, temp);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
	}
}
