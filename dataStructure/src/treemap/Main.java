package treemap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		java.util.TreeMap<String, String> tree = new java.util.TreeMap<String, String>();
		tree.put("새로운 값1", "김건");
		tree.put("새로운 값2", "아아아");

		Random ran = new Random();
		MyTreeMap<Integer, String> map = new MyTreeMap<Integer, String>();
		map.put(50, "50");
		map.put(60, "60");
		map.put(56, "56");
		map.put(55, "55");
		map.put(57, "57");
		map.put(69, "69");
		map.put(65, "65");
		map.put(70, "70");
		map.put(40, "40");
		map.put(35, "35");
		map.put(32, "32");
		map.put(36, "36");
		map.put(45, "45");
		map.put(44, "44");
		map.put(46, "46");

		map.remove(46);
		System.out.println(map.get(50));
		System.out.println(map.get(60));
		System.out.println(map.get(56));
		System.out.println(map.get(55));
		System.out.println(map.get(57));
		System.out.println(map.get(69));
		System.out.println(map.get(65));
		System.out.println(map.get(70));
		System.out.println(map.get(40));
		System.out.println(map.get(35));
		System.out.println(map.get(32));
		System.out.println(map.get(36));
		System.out.println(map.get(45));
		System.out.println(map.get(44));
		System.out.println(map.get(46));
	}
}
