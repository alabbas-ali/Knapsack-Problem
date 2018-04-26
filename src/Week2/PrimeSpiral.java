package Week2;

import java.util.LinkedList;
import java.util.Scanner;

public class PrimeSpiral {
	
	public static boolean[] isVisited;	
	static boolean[] isPrime = getPrimes(10000);
	
	static int X , Y;
	
	public static int[] gitCoordinate(int N) {
		int d = (int) Math.floor(1 / 2 + Math.sqrt(N / 4 - 1 / 4));
		int Nrem = N - (4 * d ^ 2 - 4 * d + 2);
		int[] pos= {0,0};
		if (Nrem <= (2 * d - 1)) {
			pos[0] = d;
			pos[0] = -d + 1 + Nrem;
		} else if ((2 * d - 1) <= Nrem && Nrem <= (4 * d - 1)) {
			pos[0] = 3 * d - 1 - Nrem; // d-(Nrem-(2d-1))
			pos[0] = d;
		} else if (4 * d - 1 <= Nrem && Nrem <= 6 * d - 1) {
			pos[0] = -d;
			pos[0] = 5 * d - 1 - Nrem; // d-(Nrem-(4d-1))
		} else if (6 * d - 1 <= Nrem) {
			pos[0] = -7 * d + 1 + Nrem; // -d+(Nrem-(6d-1))
			pos[0] = -d;
		}
		return pos;
	}
	
	public static int[] spiralCoordinate(int n) {
	    // given n an index in the squared spiral
	    // p the sum of point in inner square
	    // a the position on the current square
	    // n = p + a
	    int r = (int) (Math.floor((Math.sqrt(n + 1) - 1) / 2) + 1);
	    // compute radius : inverse arithmetic sum of 8+16+24+...=
	    int p = (8 * r * (r - 1)) / 2;
	    // compute total point on radius -1 : arithmetic sum of 8+16+24+...
	    int en = r * 2;
	    // points by face
	    int a = (1 + n - p) % (r * 8);
	    // compute de position and shift it so the first is (-r,-r) but (-r+1,-r)
	    // so square can connect
	    int[] pos= {0,0};
	    switch ((int) Math.floor(a / (r * 2))) {
	        // find the face : 0 top, 1 right, 2 bottom, 3 left
	        case 0:
	        	pos[0] = (int) (a - r);
	        	pos[1] = -r;
	            break;
	        case 1:
	        	pos[0] = r;
	        	pos[1] = (int) ((a % en) - r);
	            break;
	        case 2:
	        	pos[0] = (int) (r - (a % en));
	        	pos[1] = r;
	            break;
	        case 3:
	        	pos[0] = -r;
	        	pos[1] = (int) (r - (a % en));
	           break;
	    }
	    return pos;
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
				int[] pos = spiralCoordinate(current);
				//System.out.println("current : " + current);
				int next1 = spiral(pos[0] - 1, pos[1]);
				int next2 = spiral(pos[0], pos[1] - 1);
				int next3 = spiral(pos[0] + 1, pos[1]);
				int next4 = spiral(pos[0], pos[1] + 1);
				//System.out.println("Next : " + next1 + " "+ next2 + " "+ next3 + " "+ next4);
				if (next1 <= 10000 && !isVisited[next1] && !isPrime[next1]) {
					queue.addLast(next1);
					step[next1] = step[current] + 1;
					isVisited[next1] = true;
				}
				if (next2 <= 10000 && !isVisited[next2] && !isPrime[next2]) {
					queue.addLast(next2);
					step[next2] = step[current] + 1;
					isVisited[next2] = true;
				}
				if (next3 <= 10000 && !isVisited[next3] && !isPrime[next3]) {
					queue.addLast(next3);
					step[next3] = step[current] + 1;
					isVisited[next3] = true;
				}
				if (next4 <= 10000 && !isVisited[next4] && !isPrime[next4]) {
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
