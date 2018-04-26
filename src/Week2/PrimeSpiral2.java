package Week2;


import java.util.LinkedList;
import java.util.Scanner;

public class PrimeSpiral2 {
	static boolean[] isPrime = getPrimes(10000);

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
			boolean[] isVisited = new boolean[10000];
			int[] step = new int[10000];
			LinkedList<Integer> queue = new LinkedList<>();
			queue.addLast(start);
			isVisited[start] = true;
			while (
				!queue.isEmpty()
			) {
				
				int current = queue.pop();
				
				if (current == end) {
					found = true;
					break;
				}
				
				for (int j = 0; j <= 9; j++) {
					int next1 = getNext(1, j, current);
					int next2 = getNext(2, j, current);
					int next3 = getNext(3, j, current);
					int next4 = getNext(4, j, current);
					
					if (!isVisited[next1]) {
						queue.addLast(next1);
						step[next1] = step[current] + 1;
						isVisited[next1] = true;
					}
					
					if (!isVisited[next2]) {
						queue.addLast(next2);
						step[next2] = step[current] + 1;
						isVisited[next2] = true;
					}
					
					if (!isVisited[next3]) {
						queue.addLast(next3);
						step[next3] = step[current] + 1;
						isVisited[next3] = true;
					}
					
					if (!isVisited[next4]) {
						queue.addLast(next4);
						step[next4] = step[current] + 1;
						isVisited[next4] = true;
					}
					
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

	public static int getNext(int flag, int i, int current) {
		int next = 0;
		if (flag == 1) {
			if (i == 0) {
				return current;
			}
			next = current % 1000 + i * 1000;
		}
		if (flag == 2) {
			int t = current / 1000;
			next = t * 1000 + current % 1000 % 100 + i * 100;
		}
		if (flag == 3) {
			int t = current / 100;
			int tt = current % 10;
			next = t * 100 + i * 10 + tt;
		}
		if (flag == 4) {
			next = current / 10 * 10 + i;

		}
		if(isPrime[next]) {
			return current;
		}
		return next;
	}

}
