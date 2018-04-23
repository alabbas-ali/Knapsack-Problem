package Week2;

import java.util.LinkedList;
import java.util.Scanner;

public class PrimeSpiral {
	
	public static boolean[] isVisited;	
	static boolean[] isPrime = getPrimes(10000);
	
	static int X , Y;
	
	public static void gitCoordinate(int N) {
		int d = (int) Math.floor(1 / 2 + Math.sqrt(N / 4 - 1 / 4));
		int Nrem = N - (4 * d ^ 2 - 4 * d + 2);
		if (Nrem <= (2d - 1)) {
			X = d;
			Y = -d + 1 + Nrem;
		} else if ((2d - 1) <= Nrem && Nrem <= (4d - 1)) {
			X = 3 * d - 1 - Nrem; // d-(Nrem-(2d-1)) 
			Y = d;
		} else if (4d - 1 <= Nrem && Nrem <= 6d - 1) {
			X = -d;
			Y = 5 * d - 1 - Nrem; // d-(Nrem-(4d-1)) 
		} else if (6d - 1 <= Nrem) {
			X = -7 * d + 1 + Nrem; // -d+(Nrem-(6d-1))
			Y = -d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int start;
        int end;
        int n = 0;
        while (
			sc.hasNextInt() && 
			(start = sc.nextInt()) >= 1 && 
			(end = sc.nextInt()) >= 1 && 
			n++ <= 50
		) {
        	boolean found = false;
            isVisited = new boolean[10000];
            int[] step = new int[10000];
			LinkedList<Integer> queue = new LinkedList<>();
			queue.addLast(start);
			isVisited[start] = true;
			while (!queue.isEmpty()) {
				int current = queue.pop();
				if (current == end) {
					found = true;
					break;
				}
				gitCoordinate(current);
				System.out.println("current : " + current);
				int next1 = spiral(X - 1, Y);
				int next2 = spiral(X, Y - 1);
				int next3 = spiral(X + 1, Y);
				int next4 = spiral(X, Y + 1);
				System.out.println("Next : " + next1 + " "+ next2 + " "+ next3 + " "+ next4);
				if (!isVisited[next1] && !isPrime[next1] && next1 <= 10000) {
					queue.addLast(next1);
					step[next1] = step[current] + 1;
					isVisited[next1] = true;
				}
				if (!isVisited[next2] && !isPrime[next2] && next1 <= 10000) {
					queue.addLast(next2);
					step[next2] = step[current] + 1;
					isVisited[next2] = true;
				}
				if (!isVisited[next3] && !isPrime[next3] && next1 <= 10000) {
					queue.addLast(next3);
					step[next3] = step[current] + 1;
					isVisited[next3] = true;
				}
				if (!isVisited[next4] && !isPrime[next4] && next1 <= 10000) {
					queue.addLast(next4);
					step[next4] = step[current] + 1;
					isVisited[next4] = true;
				}
			}
			if(found) {
				System.out.println("Case " + n + ": " + step[end]);
			} else {
				System.out.println("Case " + n + ": impossible");
			}
        }
        sc.close();
	}
	
	private static int spiral(int x, int y) {
		int pos, squ;
		// Horizontal row at top
		if (y >= 0 && (x >= 1 - y && x < y)) {
			pos = x + y - 1;
			squ = (2 * y - 1) * (2 * y - 1);
			// Horizontal row at bottom
		} else if (y < 0 && (x >= y && x <= -y)) {
			pos = -x - y;
			squ = 4 * y * y;
			// Vertical row on right
		} else if (x > 0) {
			pos = -x - y;
			squ = 4 * x * x;
			// Vertical row on left
		} else {
			squ = (1 - 2 * x) * (1 - 2 * x);
			pos = x + y - 1;
		}
		return squ + pos;
	}
	
	private static boolean[] getPrimes(int n) {
        boolean[] a = new boolean[n];
        a[0] = false;
        a[1] = false;
        a[2] = true;
        a[3] = true;
        for (int i = 3; i <= n; i += 3) {
        	 a[i] = checkPrime(i);
        }
        return a;
    }
    
    private static boolean checkPrime(int number) {
		if (number % 2 == 0)
			return false;
		int root = (int) Math.sqrt((double) number);
		for (int i = 3; i <= root; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
	
}
