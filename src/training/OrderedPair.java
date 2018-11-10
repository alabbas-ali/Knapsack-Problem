package training;

interface Pair<K, V> {
	public K getKey();
	public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {

	private K key;
	private V value;

	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	public String toString() {
		return "{" + this.getKey() + ":" + this.getValue() + "}";
	}
	
	public static void main(String[] args) {
		Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
		Pair<String, String>  p2 = new OrderedPair<>("hello", "world");
		
		System.out.println("The First Pair is :" + p1);
		System.out.println("The Secound Pair is :" + p2);
	}
	
}


