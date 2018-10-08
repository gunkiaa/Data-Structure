package treemap;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author kimgun
 * @date 2018.10.08
 * @param <K>
 * @param <V>
 */
public class MyTreeMap<K, V> {
	private Node first;
	private int size;

	public MyTreeMap() {
		this.first = null;
		this.size = 0;
	}

	/** key와 value를 관리하고 왼쪽 노드와 오른쪽 노드를 가지고 있음.
	 * @author kimgun
	 */
	private class Node implements Comparable<K>, Map.Entry<K, V> {
		private Node right;
		private Node left;

		private K key;
		private V value;

		public Node(K key, V value) {
			this.right = null;
			this.left = null;
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

		public Node getRight() {
			return this.right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return this.left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setKey(K key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return "KEY:" + this.key + " VALUE:" + this.value;
		}

		@Override
		public int compareTo(K key) {
			int thisKeyHash = this.key.hashCode();
			int keyHash = key.hashCode();

			if (thisKeyHash > keyHash) {
				return -1;
			} else if (thisKeyHash < keyHash) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	/** 노드를 추가함.
	 * @param key
	 * @param value
	 * @author kimgun
	 * @return
	 */
	public V put(K key, V value) {
		Node addNode = new Node(key, value);
		if (this.first == null) {
			this.first = addNode;
		} else {
			Node searchNode = this.first;
			Node parentsNode = null;
			int result = 0;
			while (searchNode != null) {
				result = searchNode.compareTo(key);

				parentsNode = searchNode;
				if (result > 0) {
					searchNode = searchNode.getRight();
				} else if (result < 0) {
					searchNode = searchNode.getLeft();
				} else {
					return searchNode.setValue(value);
				}
			}
			if (result < 0)
				parentsNode.setLeft(addNode);
			else {
				parentsNode.setRight(addNode);
			}
		}
		this.size++;
		return null;
	}

	/** 노드를 얻어옴.
	 * @param key
	 * @author kimgun
	 * @return
	 */
	public V get(Object key) {
		Node searchNode = this.first;
		int result = 0;
		while (searchNode != null) {
			result = searchNode.compareTo((K) key);

			if (result > 0) {
				searchNode = searchNode.getRight();
			} else if (result < 0) {
				searchNode = searchNode.getLeft();
			} else {
				return searchNode.getValue();
			}
		}
		return null;
	}

	/** size를 얻어옴.
	 * @author kimgun
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**배열이 비었는 지를 확인
	 * @return
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	/**key가 존재하는 지 확인
	 * @param key
	 * @author kimgun
	 * @return
	 */
	public boolean containsKey(Object key) {
		if (this.get((K) key) != null) {
			return true;
		}
		return false;
	}

	/**value가 존재하는 지 확인
	 * @param value
	 * @author kimgun
	 * @return
	 */
	public boolean containsValue(Object value) {
		return false;
	}

	/**노드를 삭제함.
	 * @param key
	 * @author kimgun
	 * @return
	 */
	public V remove(Object key) {
		Node removeNode = this.first;
		Node parentsNode = null;
		int result = 0;

		//삭제할 노드가 부모의 오른쪽 노드인지, 아니면 왼쪽 노드인지를 나타내는 변수, 기본 오른쪽.
		boolean isRight = false;

		boolean isPower = true;
		while (isPower) {
			result = removeNode.compareTo((K) key);

			if (result > 0) {
				parentsNode = removeNode;
				removeNode = removeNode.getRight();

				//삭제할 노드는 부모의 오른쪽 노드
				isRight = true;
			} else if (result < 0) {
				parentsNode = removeNode;
				removeNode = removeNode.getLeft();

				//삭제할 노드는 부모의 왼쪽 노드
				isRight = false;
			} else {

				//삭제할 노드의 라이트와 레프트가 모두 있을 경우
				//삭제할 노드 오르쪽 노드의 왼쪽 끝을 찾기 위한 변수
				Node searchLeftNode = removeNode.getRight();

				if (removeNode.key.hashCode() == this.first.key.hashCode()) {
					if (removeNode.getRight() == null && removeNode.getLeft() == null) {
						this.first = null;
					} else if (removeNode.getRight() != null && removeNode.getLeft() == null) {
						this.first = this.first.getRight();
					} else if (removeNode.getRight() == null && removeNode.getLeft() != null) {
						this.first = this.first.getLeft();
					} else if (removeNode.getRight() != null && removeNode.getLeft() != null) {
						//삭제할 노드의 오른쪽 노드의 왼쪽 끝을 찾아줌
						while (searchLeftNode.getLeft() != null) {
							searchLeftNode = searchLeftNode.getLeft();
						}
						searchLeftNode.setLeft(this.first.getLeft());
						this.first = this.first.getRight();
					}
				} else if (removeNode.getRight() != null && removeNode.getLeft() != null) {
					//삭제할 노드의 오른쪽 노드의 왼쪽 끝을 찾아줌
					while (searchLeftNode.getLeft() != null) {
						searchLeftNode = searchLeftNode.getLeft();
					}
					//삭제할 노드의 오른쪽 노드의 왼쪽 끝의 왼쪽에 삭제할 노드의 왼쪽을 넣어줌
					searchLeftNode.setLeft(removeNode.getLeft());

					if (isRight) {
						parentsNode.setRight(removeNode.getRight());
					} else {
						parentsNode.setLeft(removeNode.getRight());
					}
				} else if (removeNode.getRight() == null && removeNode.getLeft() != null) {
					if (isRight) {
						parentsNode.setRight(removeNode.getLeft());
					} else {
						parentsNode.setLeft(removeNode.getLeft());
					}
				} else if (removeNode.getRight() != null && removeNode.getLeft() == null) {
					if (isRight) {
						parentsNode.setRight(removeNode.getRight());
					} else {
						parentsNode.setLeft(removeNode.getRight());
					}
				} else if (removeNode.getRight() == null && removeNode.getLeft() == null) {
					if (isRight) {
						parentsNode.setRight(null);
					} else {
						parentsNode.setLeft(null);
					}
				}
				isPower = false;
			}
		}
		this.size--;
		return null;
	}

	/** 넘어온 컬렉션에 모든 노드를 추가
	 * @param m
	 * @author kimgun
	 */
	public void putAll(Map<K, V> m) {
		Set<Entry<K, V>> set = m.entrySet();

		for (Entry<K, V> ety : set) {
			this.put(ety.getKey(), ety.getValue());
		}
	}

	/**
	 * 배열을 비움.
	 * @author kimgun
	 */
	public void clear() {
		this.first = null;
		this.size = 0;
	}

	/**모든 key를 Set형태로 반환
	 * @author kimgun
	 * @return
	 */
	public Set<K> keySet() {
		return null;
	}

	/**모든 value를 컬렉션형태로 반환
	 * @author kimgun
	 * @return
	 */
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	/**모든 엔트리를 Set형태로 반환
	 * @author kimgun
	 * @return
	 */
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
