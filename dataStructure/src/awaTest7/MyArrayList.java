package awaTest7;

import java.util.List;

/**
 * @author kimgun
 * @date 2018.08.22
 * @param <E>
 */
public class MyArrayList<E> {

	// 전역에서 사용될 제네릭 배열
	private E[] arr;

	// 값이 들어있는 실질적인 크기를 나타내는 변수
	private int size;

	/**
	 * 전연 변수를 초기화한다.
	 * @author kimgun
	 */
	public MyArrayList() {
		this.arr = (E[]) new Object[10];
		this.size = 0;
	}

	/**
	 * 넘어온 index가 0보다 작거나 size의 크기보다 큰지 검사한다.
	 * @param index 검사하고자 하는 index 값
	 * @author kimgun
	 */
	private void checkIndexBounds(int index, int max) {
		if (max < index || index < 0) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}
	}

	/**
	 * 배열에 마지막 위치에 값을 넣는다.
	 * @param e 배열에 추가할 값
	 * @return 
	 * @author kimgun
	 */
	public boolean add(E e) {

		if (size >= arr.length) {
			E[] tempArr = (E[]) new Object[arr.length * 2];
			System.arraycopy(arr, 0, tempArr, 0, arr.length);

			arr = tempArr;
		}
		arr[size] = e;
		size++;
		return true;
	}

	/**
	 * @param index 값을 넣을 위치를 나타내는 변수
	 * @param element 배열에 추가할 값
	 * @author kimgun
	 */
	public void add(int index, E element) {
		checkIndexBounds(index, size);
		add(element);

		for (int i = size - 1; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		arr[index] = element;
	}

	/**
	 * 배열의 마지막 위치부터 List 배열의 값들을 추가한다.
	 * @param c 배열에 추가할 List
	 * @return
	 * @author kimgun
	 */
	public boolean addAll(List<E> c) {
		for (int i = 0; i < c.size(); i++) {
			add(c.get(i));
		}
		return false;
	}

	/**
	 * index번째 부터 배열에 값들을 추가한다.
	 * @param index List안의 값들을 넣기 시작할 index 위치를 나타내는 변수
	 * @param c 배열에 넣을 값들을 가지고 있는 List변수
	 * @return
	 * @author kimgun
	 */
	public boolean addAll(int index, List<E> c) {
		for (int i = c.size() - 1; i > index - 1; i--) {
			add(index, c.get(i));
		}
		return false;
	}

	/**
	 * 배열 안에 값을 모두 없앤다.
	 * (부가설명) 실질적으로 배열의 값들은 그대로 있더라도 사이즈가 줄어듦으로서
	 * 실질적으로 지운 것과 같은 효과를 볼 수 있다.
	 * @author kimgun
	 */
	public void clear() {
		size = 0;
	}

	/**
	 * 배열 안에 str과 같은 값이 있으면 true를, 없으면 false를 반환한다.
	 * @param str 배열 안의 str과 같은 값 비교를 위한 변수
	 * @return
	 * @author kimgun
	 */
	public boolean contains(E str) {
		return indexOf(str) > -1;
	}

	/**
	 * 배열 안에 List 안에 값들이 모두 있으면 true를, 하나라도 없으면 false를 반환한다.
	 * @param c str 배열 안의 str과 같은 값 비교를 위한 List 변수
	 * @return
	 * @author kimgun
	 */
	public boolean containsAll(List<E> c) {
		for (int i = 0; i < c.size(); i++) {
			if (contains(c.get(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 배열 안에 index번째 값을 반환해준다.
	 * @param 배열의 index를 나타내는 변수
	 * @return arr배열의 index번째 값을 반환
	 * @author kimgun
	 */
	public E get(int index) {
		checkIndexBounds(index, size - 1);
		return arr[index];
	}

	/**
	 * 배열 내 0번째부터 찾아서 str과 같은 값이 처음으로 발견되면 그 index를 반환한다.
	 * @param str 자신과 같은 값을 찾기 위한 변수
	 * @return 발견된 str과 같은 값의 index를 반환한다. 없을 경우, -1를 반환한다.
	 * @author kimgun
	 */
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 배열 안에 값이 아무것도 없을 경우 true를, 있을 경우 false를 반환한다.
	 * @return size가 0이면 값이 없다는 뜻으로 true를, 0이 아닐 경우 false를 반환한다.
	 * @author kimgun
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 배열 내 제일 뒤에서 부터 찾아서 str과 같은 값이 처음으로 발견되면 그 index를 반환한다.
	 * @param str 자신과 같은 값을 찾기 위한 변수
	 * @return 발견된 str과 같은 값의 index를 반환한다. 없을 경우, -1를 반환한다.
	 * @author kimgun
	 */
	public int lastIndexOf(E str) {
		for (int i = size - 1; i >= 0; i--) {
			if (arr[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 넘어온 index번째에 들어있는 배열의 값을 삭제한다.
	 * @param index 삭제할 값의 위치를 나타내는 변수
	 * @return
	 * @author kimgun
	 */
	public String remove(int index) {
		checkIndexBounds(index, size - 1);
		for (int i = index; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		size--;
		return null;
	}

	/**
	 * 넘어온 str과 같은 값이 들어있는 배열의 값을 삭제한다.
	 * @param o 삭제할 값이 들어있는 변수
	 * @return
	 * @author kimgun
	 */
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(o)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 넘어온 List안에 값과 똑같은 값은 배열에서 모두 삭제한다.
	 * @param c 삭제할 값들이 들어있는 변수
	 * @return
	 * @author kimgun
	 */
	public boolean removeAll(List<E> c) {
		for (int i = 0; i < c.size(); i++) {
			remove(c.get(i));
		}
		return false;
	}

	/**
	 * 넘어온 List안에 값과 똑같은 값만 남겨두고 나머지 값들은 배열에서 모두 삭제한다.
	 * @param c 남겨둘 값들이 들어있는 변수
	 * @return
	 * @author kimgun
	 */
	public boolean retainAll(List<E> c) {
		clear();
		addAll(c);
		return false;
	}

	/**
	 * 넘어온 index번째 값을 element로 변경한다.
	 * @param index 값을 바꿀 배열의 인덱스가 들어있는 변수
	 * @param element 바꿀 값이 들어있는 변수
	 * @return
	 * @author kimgun
	 */
	public E set(int index, E element) {
		checkIndexBounds(index, size - 1);
		E oldStr = arr[index];
		arr[index] = element;
		return oldStr;
	}

	/**
	 * 배열의 크기를 반환한다.
	 * @return
	 * @author kimgun
	 */
	public int size() {
		return this.size;
	}
}