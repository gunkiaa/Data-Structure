package awaTest7;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MyMap<K, V> {

	private MyArrayList<Entry<K, V>> list;
	private int size;

	public MyMap() {
		list = new MyArrayList<Entry<K, V>>();
		size = 0;
	}

	private class Entry<K, V> implements Map.Entry<K, V> {
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

		// 아래 toString의 역할 확인하기
		@Override
		public String toString() {
			return key + "=" + value;
		}

	}

	/**
	 * list에서 key값에 해당하는 index 조회하는 함수
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public int findIndexByKey(K key) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * list에서 value값에 해당하는 index 조회하는 함수
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public int findIndexByValue(V value) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (list.get(i).getValue().equals(value)) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * map에 entry 를 추가하는 put method
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key, V value) {
		V returnValue = null;
		int index = findIndexByKey(key);
		if (index > -1) {
			returnValue = list.get(index).getValue();
			list.get(index).setValue(value);

		} else {
			Entry ety = new Entry(key, value);
			list.add(ety);
			size++;
		}

		return returnValue;
	}

	/**
	 * key값으로 map에 들어있는 entry의 value 값을 가져오는 메서드
	 * @param key
	 * @return
	 */
	public V get(Object key) {
		int index = findIndexByKey((K) key);
		if (index > -1) {
			return list.get(index).getValue();

		}
		return null;
	}

	/**
	 * 입력받은 key 값이 map entry 에 존재하는지 확인하는 메서드
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		if (-1 < findIndexByKey((K) key)) {
			return true;
		}
		return false;
	}

	/**
	 * 입력받은 value 값이 entry 에 존재하는지 확인하는 메서드
	 * @param value
	 * @return
	 */
	public boolean containsValue(Object value) {
		if (-1 < findIndexByValue((V) value)) {
			return true;
		}

		return false;
	}

	/**
	 * 입력받은 key 값에 해당하는 map의 entry를 삭제하는 메서드
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		V remove = null;
		int index = findIndexByKey(key);
		if (-1 < index) {
			remove = list.get(index).getValue();
			list.remove(index);
			size--;
		}
		return remove;
	}

	/**
	 * map을 비우는 메서드
	 */
	public void clear() {
		size = 0;
		list = new MyArrayList<Entry<K, V>>();
	}

	/**
	 * map이 담긴 리스트의 사이즈 조회하는 메서드 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**
	 * map 이 비어있는지 여부 조회하는 메서드
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	//	public void putAll(Map<K, V> m) {
	//
	//	}

	/**
	 * 다른 Map에 있는 값을 현재 MyMap에 넣어주는 메서드
	 * @author dhkim
	 * @param m
	 */
	public void putAll(Map<? extends K, ? extends V> m) {
		Set<K> setKey = (Set<K>) m.keySet();
		for (K key : setKey) {
			put(key, m.get(key));
		}
	}

	/**
	 * value 값 list 에 담아서 return
	 * @return
	 */
	public MyArrayList<V> values() {
		MyArrayList<V> tempList = new MyArrayList<V>();
		for (int i = 0; i < list.size(); i++) {
			tempList.add(list.get(i).getValue());

		}
		return tempList;

		//		return (Collection<V>) list;
	}

	/**
	 * entry를 담은 Set 으로 return 하는 메서드
	 * @author dhkim
	 * @return
	 */
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> entrySet = new LinkedHashSet<Entry<K, V>>();
		Set<K> keys = keySet();

		for (K key : keys) {
			Entry<K, V> newEntry = new Entry<K, V>(key, get(key));
			entrySet.add(newEntry);
		}
		return entrySet;
	}

	/**
	 * map의 key값을 Set으로 담아 return 하는 메서드
	 * @author dhkim
	 * @return
	 */
	public Set<K> keySet() {
		Set<K> keys = new LinkedHashSet<K>();
		for (int i = 0; i < list.size(); i++) {
			keys.add(list.get(i).getKey());
		}
		return keys;
	}

}
