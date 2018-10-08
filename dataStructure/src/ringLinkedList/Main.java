package ringLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MyRingLinkedList list = new MyRingLinkedList();
		List<String> list2 = new ArrayList<String>();

		list.add("32");
		list.add("54");
		list.add("3");
		list.add("4");
		list.remove("32");


		System.out.println("list값들 ======");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "," + list.get(i));
		}
	}
}