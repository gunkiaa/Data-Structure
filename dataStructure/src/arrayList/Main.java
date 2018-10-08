package arrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// MyArrayList2 list = new MyArrayList2();
		MyArrayListInteger list = new MyArrayListInteger();
		List<Integer> list2 = new ArrayList<Integer>();


		System.out.println("list값들 ====== size="+list2.size());
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + "," + list2.get(i));
		}
		System.out.println("list2값들 ====== size=" + list2.size());
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + "," + list2.get(i));
		}
	}
}
