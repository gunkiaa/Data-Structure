package sort;

import java.util.ArrayList;

/**
 * @author kimgun
 * @date 2018.10.08
 */
public class SelectionSort {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(5);
		list.add(1);
		list.add(7);
		list.add(10);
		list.add(2);
		list.add(3);
		list.add(8);
		list.add(4);
		list.add(6);
		list.add(9);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println();
		System.out.println("******************** 선택 정렬 *********************");
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) > list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		System.out.println(" ====================오른차순=======================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		System.out.println();
		System.out.println(" ====================내림차순=======================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
	}
}
