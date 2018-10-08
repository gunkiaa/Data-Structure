package hashMap;

public class Main {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		map.put(31401, "김건1");
		map.put(31402, "김건2");
		map.put(31404, "김건3");
		map.put(31405, "김건4");
		map.put(31406, "김건5");
		map.put(31407, "김건6");
		map.put(31408, "김건7");
		map.put(31409, "김건8");
		//		map.put(31410, "김건9");
//		map.test();
		System.out.println(map.get(31405));
		//		System.out.println(map.get(31405));
	}
}
