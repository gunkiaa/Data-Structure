package queue;

import java.util.NoSuchElementException;

/**
 * @author kimgun
 * @date 2018.09.05
 */
public class MyQueue {
	//큐 안에 저장될 값이 들어갈 배열
	private String[] arr;
	//값이 갯수
	private int size;

	public MyQueue() {
		arr = new String[10];
		size = 0;
	}

	/**맨 뒤에 값을 추가한다.
	 * @param str 배열에 추가할 값
	 * @return 성공 시 true를 반환한다. 실패 시 Exception 발생
	 */
	public boolean add(String str) {
		boolean flag = true;
		if (size == arr.length) {
			flag = false;
			throw new IllegalStateException("용량이 가득 찼습니다.");
		}
		if (str.equals("")) {
			flag = false;
			throw new NullPointerException("널은 허용하지 않습니다.");
		}
		arr[size] = str;
		size++;

		return flag;
	}

	/**맨 뒤에 값을 추가한다.
	 * @param str 배열에 추가할 값
	 * @return 성공 시 true를 반환한다. 실패 시 false를 반환한다.
	 */
	public boolean offer(String str) {
		if (size == arr.length) {
			return false;
		}
		if (str.equals("")) {
			throw new NullPointerException("널은 허용하지 않습니다.");
		}
		arr[size] = str;
		size++;
		return true;
	}

	/**가장 맨 앞에 값을 반환한다.
	 * @return 배열의 맨 첫 번째 값을 반환, 없을 시 Exception
	 */
	public String element() {
		if (arr[0] == null) {
			throw new NoSuchElementException("첫 번째 요소가 없습니다.");
		}
		return arr[0];
	}

	/**가장 맨 앞에 값을 반환한다.
	 * @return 배열의 맨 첫 번째 값을 반환, 없을 시 null 반환
	 */
	public String peek() {
		if (arr[0] == null) {
			return null;
		}
		return arr[0];
	}

	/**첫 번째 값을 삭제하고, 반환해준다.
	 * @return 삭제된 첫 번째 값, 없을 시 Exception
	 */
	public String remove() {
		if (arr[0] == null || size == 0) {
			throw new NoSuchElementException("첫 번째 요소가 없습니다.");
		}
		String removeStr = arr[0];
		for (int i = 0; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[size - 1] = "";
		size--;
		return removeStr;
	}

	/**첫 번째 값을 삭제하고, 반환해준다.
	 * @return 삭제된 첫 번째 값, 없을 시 null 반환
	 */
	public String poll() {
		if (arr[0] == null || size == 0) {
			return null;
		}
		String removeStr = arr[0];
		for (int i = 0; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[size - 1] = "";
		size--;
		return removeStr;
	}
}
