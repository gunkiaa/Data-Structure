package doublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MyDoublyLinkedList list = new MyDoublyLinkedList();
		List<String> list2 = new ArrayList<String>();

		list.add("32");
		list.add("54");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add(6,"김건");
//		list.add(0, "남상엽");
//		list.add(7, "안냐세요");
//		list.remove(5);
		list.view();
//		System.out.println("list값들 ======");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(i + "," + list.get(i));
//		}
		System.out.println("====size=====");
		System.out.println(list.size);
	}
}