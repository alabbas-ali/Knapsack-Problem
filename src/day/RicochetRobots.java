//package day;
//
//import java.io.BufferedInputStream;
//import java.util.Map;
//import java.util.Queue;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//
//public class RicochetRobots {
//
//	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(new BufferedInputStream(System.in));
//		int n = scan.nextInt(), w = scan.nextInt(), h = scan.nextInt(), l = scan.nextInt();
//
//		char[][] board = new char[h][w];
//
//		State init = new State();
//
//		int endx = -1;
//		int endy = -1;
//		for (int i = 0; i < h; i++) {
//			String line = scan.next();
//			
//			for (int j = 0; j < w; j++) {
//				
//				board[i][j] = line.charAt(j);
//				if (board[i][j] == 'X') {
//					endx = i;
//					endy = j;
//					board[i][j] = '.';
//				}
//				if (board[i][j] != '.' && board[i][j] != 'W') {
//					init.put(new Point(i, j), String.valueOf(board[i][j]));
//					board[i][j] = '.';
//				}
//			}
//		}
//
//		Map<State, Integer> m = new HashMap<>();
//		m.put(init, 0);
//
//		Queue<State> q = new LinkedList<>();
//		q.add(init);
//		boolean printed = false;
//
//		while (!q.isEmpty()) {
//			State curr = q.remove();
//
//			// If answer, print, quit
//			Point end = new Point(endx, endy);
//			if (curr.containsKey(end) && curr.get(end).equals("1")) {
//				printed = true;
//				System.out.println(m.get(curr));
//				break;
//			}
//
//			// If taken too long, quit
//			if (m.get(curr) >= l) {
//				continue;
//			}
//
//			// Try moving to all spots
//			List<Point> movement = new ArrayList<>();
//			movement.add(new Point(1, 0));
//			movement.add(new Point(-1, 0));
//			movement.add(new Point(0, 1));
//			movement.add(new Point(0, -1));
//
//			//for (Entry<Point, String> pair : curr.entrySet()){
//			try {
//			for (Point spot : curr.keySet()) {
//				for (int j = 0; j < movement.size(); j++) {
//
//					String currchar = curr.get(spot);
//					State next = curr;
//					next.remove(spot);
//
//					for (int k = 0; k < 12; k++) {
//						int currx = spot.x + movement.get(j).x * k;
//						int curry = spot.y + movement.get(j).y * k;
//						if (!inrange(w, h, currx, curry)) {
//							break;
//						}
//
//						if (
//							board[currx][curry] == '.' || 
//							next.containsKey(new Point(currx, curry))
//						) {
//							int prevx = spot.x + movement.get(j).x * (k - 1);
//							int prevy = spot.x + movement.get(j).y * (k - 1);
//							next.put(new Point(prevx, prevy), currchar);
//
//							if (m.containsKey(next)) {
//								m.put(next, m.get(curr) + 1);
//								q.add(next);
//							}
//							break;
//						}
//					}
//				}
//			}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//		}
//
//		if (!printed) {
//			System.out.println("NO SOLUTION");
//		}
//
//		scan.close();
//	}
//
//	public static boolean inrange(int w, int h, int currx, int curry) {
//		return currx >= 0 && curry >= 0 && currx <= h + 1 && curry <= w + 1;
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
//	
//	@Override
//	public int hashCode() {
//		int result = 17;
//        result = 31 * result + x;
//        result = 31 * result + y;
//		return result;
//	}
//}
//
//class State extends HashMap<Point, String> {
//
//	private static final long serialVersionUID = 1L;
//
//}
