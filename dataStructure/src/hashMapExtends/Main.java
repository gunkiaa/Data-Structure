package hashMapExtends;

public class Main {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();

		map.put(31401, "김건1");
		map.put(31402, "김건2");
		map.put(31403, "김건3");
		map.put(31404, "김건4");
		System.out.println(map.toString());
	}
}