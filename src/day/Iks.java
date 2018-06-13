//package day;
//
//import java.io.BufferedInputStream;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.List;
//
//public class Iks {
//
//	static final int MAXN = 102;
//	static final int MAXV = 1000006;
//	static int n;
//	static int[] a = new int[MAXN];
//	static int[] b = new int[MAXN];
//	static int[] sieve = new int[MAXV];
//
//	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(new BufferedInputStream(System.in));
//		n = scan.nextInt();
//
//		for (int i = 0; i < n; ++i) {
//			a[i] = scan.nextInt();
//		}
//
//		List<Integer> primes = new ArrayList<>();
//
//		gen_sieve(primes);
//
//		int ans = 1;
//		int total = 0;
//		for (int p : primes) {
//			Point point = run(p);
//			for (int i = 0; i < point.x; ++i)
//				ans *= p;
//			total += point.y;
//		}
//
//		System.out.println(ans + " " + total);
//
//	}
//
//	public static void gen_sieve(List<Integer> primes) {
//		for (int i = 2; i < MAXV; ++i) {
//			if (sieve[i] == 0) {
//				primes.add(i);
//				sieve[i] = i;
//			}
//
//			for (int j = 0; 
//					j < primes.size() && 
//					primes.get(j) <= sieve[i] && 
//					i * primes.get(j) < MAXV; 
//					++j) {
//				
//				sieve[i * primes.get(j)] = primes.get(j);
//			}
//		}
//	}
//
//	public static Point run(int p) {
//		int total = 0;
//		for (int i = 0; i < n; ++i) {
//			b[i] = 0;
//			int x = a[i];
//			while (x % p == 0) {
//				++b[i];
//				x /= p;
//			}
//
//			total += b[i];
//		}
//
//		int ret = total / n;
//		int moves = 0;
//
//		for (int i = 0; i < n; ++i) {
//			moves += Math.max(0, ret - b[i]);
//		}
//
//		return new Point(ret, moves);
//	}
//
//}
//
//class Point {
//	int x;
//	int y;
//
//	public Point(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//}
