package hashMapExtends;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import arrayList.MyArrayList;

/**
 * @author kimgun
 *
 * @param <K> key
 * @param <V> value
 */
public class MyLinearMap<K, V> {

	//key와 value를 가지고 있는 Entry를 담기 위한 list
	private MyArrayList<Entry<K, V>> list;
	//배열의 size
	private int size;

	/**
	 * 초기화를 해준다.
	 * @author kimgun
	 */
	public MyLinearMap() {
		list = new MyArrayList<Entry<K, V>>();
		size = 0;
	}

	/**key와value를 가지고 있는 이너 클래스
	 *
	 * @param <K> Key
	 * @param <V> Value
	 * @author kimgun
	 */
	protected class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public V setValue(V value) {
			V oldV = this.value;
			this.value = value;
			return oldV;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}
	}

	/**넘어온 파라미터의 널 체크를 함
	 * @param key null체크를 하고자 하는 변수
	 * @author kimgun
	 */
	private void nullCheck(K key) {
		if (key == null) {
			throw new NullPointerException("널이 들어올 수 없습니다.");
		}
	}

	/**해당 key의 인덱스를 반환해줌.
	 * @param key 찾고자 하는 인덱스를 나타내는 변수
	 * @return 인덱스를 반환해준다.
	 * @author kimgun
	 */
	public Entry<K, V> getEntryByKey(K key) {
		nullCheck(key);
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				return list.get(i);
			}
		}
		return null;
	}

	/**해당 키의 value를 반환해준다.
	 * @param key value를 찾고자 하는 key의 값
	 * @return 넘어온 key의 value
	 * @author kimgun
	 */
	private V getValue(K key) {
		nullCheck(key);
		Entry<K, V> ety = getEntryByKey(key);

		if (ety != null) {
			return ety.getValue();
		}
		return null;
	}

	/**값을 추가해준다.
	 * @param key 값의 키
	 * @param value 키에 매칭되는 값
	 * @return 만약, 추가할 키와 같은 키가 이미 있으면 원래 키에 있던 값을 반환해주고, 아니면 null을 반환해준다.
	 * @author kimgun
	 */
	public V put(K key, V value) {
		nullCheck(key);

		V returnV = null;

		Entry<K, V> ety = getEntryByKey(key);
		if (ety != null) {
			returnV = (V) ety.getValue();
			ety.setValue(value);
		} else {
			ety = new Entry<K, V>(key, value);
			list.add(ety);
			size++;
		}
		return returnV;
	}

	/**넘어온 key의 값을 넘겨준다.
	 * @param key 찾고자 하는 value의 key
	 * @return key의 매칭되는 value를 반환해준다.
	 * @author kimgun
	 */
	public V get(Object key) {
		nullCheck((K) key);
		return getValue((K) key);
	}

	/**size를 반환해준다.
	 * @return size
	 * @author kimgun
	 */
	public int size() {
		return this.size;
	}

	/**배열에 요소가 없는지 판단
	 * @return size가 0이면 true를, 아니면 false를 반환해준다.
	 * @author kimgun
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**넘어온 key와 같은 키가 있는지 판단한다.
	 * @param key 같은 값이 있는 지 판단하기 위함
	 * @return 있으면 true, 없으면 false
	 * @author kimgun
	 */
	public boolean containsKey(Object key) {
		return getEntryByKey((K) key) != null;
	}

	/**넘어온 value와 같은 값이 있는지 판단한다.
	 * @param value value와 같은 값이 있는 지 판단하기 위함 
	 * @return 있으면 true, 없으면 false
	 * @author kimgun
	 */
	public boolean containsValue(Object value) {
		for (int i = 0; i < size; i++) {
			if (list.get(i).getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**넘어온 key에 해당하는 엔트리를 삭제한다.
	 * @param key 삭제할 엔트리의 key
	 * @return 삭제가 되면 삭제한 엔트리의 value를, 아니면 null을 반환한다.
	 * @author kimgun
	 */
	public V remove(K key) {
		nullCheck(key);

		V remove = null;

		Entry<K, V> ety = getEntryByKey(key);
		if (ety != null) {
			remove = ety.getValue();
			list.remove(ety);
		}
		size--;
		return remove;
	}

	/**배열에 모두 추가해준다.
	 * @param m 추가할 리스트
	 * @author kimgun
	 */
	public void putAll(Map<K, V> m) {
		Set<K> keys = m.keySet();

		for (K key : keys) {
			put(key, m.get(key));
		}
	}

	/**배열 안에 모든 엔트리를 반환해준다.
	 * @return 엔트리를 반환
	 * @author kimgun
	 */
	public Set<Entry<K, V>> entrySet() {
		Set<K> keys = keySet();

		Set<Entry<K, V>> entry = new LinkedHashSet<Entry<K, V>>();
		for (K key : keys) {
			entry.add(new Entry(key, get(key)));
		}

		return entry;
	}

	/**엔트리들의 key를 모두 Set형태로 반환해준다.
	 * @return keys 배열 안에 모든 key를 반환
	 * @author kimgun
	 */
	public Set<K> keySet() {
		Set<K> keys = new LinkedHashSet<K>();

		for (int i = 0; i < size; i++) {
			keys.add(list.get(i).getKey());
		}
		return keys;
	}

	/**
	 * 배열 안에 요소들을 모두 비워준다
	 * @author kimgun
	 */
	public void clear() {
		size = 0;
		list = new MyArrayList<Entry<K, V>>();
	}
}
