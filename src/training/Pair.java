//package training;
//
//public class Pair<K, V> {
//
//	private K key;
//	private V value;
//
//	public Pair(K key, V value) {
//		this.key = key;
//		this.value = value;
//	}
//
//	public void setKey(K key) {
//		this.key = key;
//	}
//
//	public void setValue(V value) {
//		this.value = value;
//	}
//
//	public K getKey() {
//		return key;
//	}
//
//	public V getValue() {
//		return value;
//	}
//
//	public static void main(String[] args) {
//		Pair<Integer, String> p1 = new Pair<>(1, "apple");
//		Pair<Integer, String> p2 = new Pair<>(2, "pear");
//		boolean same = Util.<Integer, String>compare(p1, p2);
//		System.out.println("compare P1 and P2 : " + same);
//	}
//}
//
//
//
//
//class Util {
//	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
//		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
//	}
//}
//
//
//
//
//class PairUtil {
//	public static <A extends Number, B extends Number> double add(Pair<A, B> p) {
//		return p.getKey().doubleValue() + p.getValue().doubleValue();
//	}
//
//	public static <A, B> Pair<B, A> swap(Pair<A, B> p) {
//		A first = p.getKey();
//		B second = p.getValue();
//		return new Pair<B, A>(second, first);
//	}
//}
