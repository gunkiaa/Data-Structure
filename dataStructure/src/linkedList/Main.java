package linkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MyLinkedListString list = new MyLinkedListString();
		List<String> list2 = new ArrayList<String>();

		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.remove("1");

		System.out.println("list2값들 ======");
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + "," + list2.get(i));
		}
		System.out.println("list값들 ======");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "," + list.get(i));
		}
	}
}