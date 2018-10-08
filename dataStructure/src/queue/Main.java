package queue;

public class Main {
	public static void main(String[] args) {
		MyQueue qu = new MyQueue();
		qu.add("첫 번째 요소");
		qu.add("두 번째 요소");
		qu.add("세 번째 요소");
		qu.add("네 번째 요소");
		qu.add("다섯 번째 요소");

		qu.offer("여섯 번째 요소");
		qu.offer("일곱 번째 요소");
		qu.offer("여덟 번째 요소");
		qu.offer("아홉 번째 요소");
		//		qu.offer("열 번째 요소");
		System.out.println(qu.offer("1"));
		qu.remove();
		qu.remove();
		qu.remove();
		qu.remove();
		qu.remove();
		qu.remove();
		qu.remove();
		qu.remove();
		qu.remove();
		qu.remove();

		System.out.println(qu.element());
	}
}
