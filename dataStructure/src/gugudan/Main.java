package gugudan;

import java.util.ArrayList;
import java.util.LinkedList;

import arrayList.MyArrayList;
import doublyLinkedList.MyDoublyLinkedList;
import linkedList.MyLinkedList;
import linkedList.MyLinkedListString;

public class Main {
	public static void main(String[] args) {
		MyArrayList<Integer> list1 = new MyArrayList<Integer>();
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		MyDoublyLinkedList<Integer> list3 = new MyDoublyLinkedList<Integer>();

		int num = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				list1.add(i + 1);
				list2.add(j + 1);
				list3.add(list1.get(num) * list2.get(num));
				num++;
			}
		}
		num = 0;
		for (int i = 0; i < 9; i++) {
			System.out.println("=========" + (i + 1) + "단=========");
			for (int j = 0; j < 9; j++) {
				System.out.println(list1.get(num) + " * " + list2.get(num) + " = " + (list1.get(num) * list2.get(num)));
				num++;
			}
		}
	}
}