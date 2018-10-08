package linearMap;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		MyLinearMap<Integer, String> map = new MyLinearMap<Integer, String>();
		map.put(31405, "김건");
//		map.remove(31405);
		System.out.println(map.containsValue("김건"));
		
		System.out.println(map.get(31405));
		
		System.out.println(map.remove(31405));
		
		System.out.println(map.get(31405));
	}
}
