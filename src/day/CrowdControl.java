//package day;
//
//import java.io.BufferedInputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class CrowdControl {
//	
//	static final int MAXN = 1003;
//	static int n, m;
//	static int[] u = new int[MAXN];
//	static int[] v = new int[MAXN];
//	static int[] w = new int[MAXN];
//	
//	static int[] aug= new int[MAXN];
//	static int[] previous= new int[MAXN];
//	static boolean[] on_path= new boolean[MAXN];
//	static List<List<Point>> graph = new ArrayList<>(MAXN);
//	
//	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(new BufferedInputStream(System.in));
//		n = scan.nextInt();
//		m = scan.nextInt();
//		
//		List<Point> graph = new ArrayList<>();
//		
//		for (int i = 0; i < m; ++i) {
//			u[i] = scan.nextInt();
//			v[i] = scan.nextInt();
//			w[i] = scan.nextInt();
//			graph.set(u[i], new Point(v[i], w[i]));
//			graph.set(v[i], new Point(u[i], w[i]));
//		}
//		
//		Queue<Point> pq = new PriorityQueue<>();
//		pq.add(new Point(1000000000, 0));
//		
//		
//	}
//
//}
//
//class Point {
//int x;
//int y;
//
//public Point(int x, int y) {
//	super();
//	this.x = x;
//	this.y = y;
//}
//
//
