package hashMapExtends;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import arrayList.MyArrayList;

/**
 * @author kimgun
 * @date 2018.09.11
 * @param <K> Key
 * @param <V> Value
 */
public class MyHashMap<K, V> extends MyLinearMap<K, V> {

	//key와 value를 가지고 있는 Entry를 담기 위한 list
	private MyArrayList<MyLinearMap<K, V>> list;
	//배열의 size
	private int size;

	//hashCode를 나눌 값
	private int hashDeviceNo;
	//생성자로 hashDeviceNo를 정해주지 않을 경우의 크기
	private final int DEFAULT_NO = 3;

	/** 초기화를 담당함
	 * @param hashDeviceNo 초기화값
	 * @author kimgun
	 */
	public MyHashMap(int hashDeviceNo) {
		this.hashDeviceNo = hashDeviceNo;
		settingSize(hashDeviceNo);
	}

	/**
	 * 초기화를 담당
	 * @author kimgun
	 */
	public MyHashMap() {
		this.hashDeviceNo = DEFAULT_NO;
		settingSize(3);
	}

	public void test() {
		for (int k = 0; k < list.size(); k++) {
			System.out.println("======" + k + "=======");
			for (int i = 0; i < list.get(k).size(); i++) {
				System.out.println(list.get(k).get(i));
			}
			System.out.println("size==" + list.get(k).size());
		}
	}

	/** 두 생성자가 호출하는 초기화 담당 메소드
	 * @param hashDeviceNo 초기화값
	 * @author kimgun
	 */
	public void settingSize(int hashDeviceNo) {
		list = new MyArrayList<MyLinearMap<K, V>>();

		for (int i = 0; i < hashDeviceNo; i++) {
			list.add(new MyLinearMap<K, V>());
		}
		size = 0;
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
	@Override
	public Entry<K, V> getEntryByKey(K key) {
		//return super.getEntryByKey(key);
		int keys = getHash(key);
		return list.get(keys).getEntryByKey(key);
	}

	/**List 안에 List들의 사이즈를 비교한 후 max가 min보다 2배 이상 클 경우 true를 아니면, false를 반환한다.
	 * @return true/false
	 * @author kimgun
	 */
	private boolean spaceCheck() {
		int min = this.size;
		int max = -1;

		for (int i = 0; i < list.size(); i++) {
			if (min > list.get(i).size()) {
				min = list.get(i).size();
			}
			if (max < list.get(i).size()) {
				max = list.get(i).size();
			}
		}
		if (min != 0 && (max > min * 2)) {
			Set<Entry<K, V>> etys = entrySet();
			hashDeviceNo *= 2;
			settingSize(hashDeviceNo);

			for (Entry<K, V> ety : etys) {
				int listIdx = getHash(ety.getKey());
				list.get(listIdx).put(ety.getKey(), ety.getValue());
			}
			return true;
		}
		return false;
	}

	/**key의 해쉬코드를 hashDeviceNo로 나눈 절대값을 반환해준다.
	 * @param key 나누기 위한 피연산자
	 * @return 절대값을 반환
	 * @author kimgun
	 */
	private int getHash(K key) {
		return Math.abs(key.hashCode() % this.hashDeviceNo);
	}

	/**값을 추가해준다.
	 * @param key 값의 키
	 * @param value 키에 매칭되는 값
	 * @return 만약, 추가할 키와 같은 키가 이미 있으면 원래 키에 있던 값을 반환해주고, 아니면 null을 반환해준다.
	 * @author kimgun
	 */
	public V put(K key, V value) {
		nullCheck(key);
		spaceCheck();

		V returnV = null;
		Entry<K, V> ety = getEntryByKey(key);
		if (ety != null) {
			returnV = (V) ety.getValue();
			ety.setValue(value);
		} else {
			int listIdx = getHash(key);
			list.get(listIdx).put(key, value);
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
		return this.getEntryByKey((K) key).getValue();
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
		Set<Entry<K, V>> etys = entrySet();

		for (Entry<K, V> ety : etys) {
			if (ety.getValue().equals(value)) {
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

		int listIdx = getHash(key);

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
			Entry<K, V> ety = new Entry<K, V>(key, get(key));
			entry.add(ety);
			//			entry.add(new Entry<K, V>(key, get(key)));
		}
		return entry;
	}

	/**엔트리들의 key를 모두 Set형태로 반환해준다.
	 * @return keys 배열 안에 모든 key를 반환
	 * @author kimgun
	 */
	public Set<K> keySet() {
		Set<K> keys = new LinkedHashSet<K>();

		for (int i = 0; i < list.size(); i++) {
			keys.addAll(list.get(i).keySet());
		}
		return keys;
	}

	/**엔트리 안에 값들을 리스트 형태로 반환한다.
	 * @return MyArrayList<V>
	 */
	public MyArrayList<V> values() {
		// TODO Auto-generated method stub
		MyArrayList<V> list = new MyArrayList<V>();

		Set<K> keys = keySet();

		for (K key : keys) {
			list.add(get(key));
		}
		return list;
	}

	/**
	 * 배열 안에 요소들을 모두 비워준다
	 * @author kimgun
	 */
	public void clear() {
		size = 0;
		list = new MyArrayList<MyLinearMap<K, V>>();
	}
}
