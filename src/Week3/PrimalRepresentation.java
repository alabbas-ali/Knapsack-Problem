package Week3;

import java.util.Scanner;

public class PrimalRepresentation {
	
	private static void primalRepresentation(long n) {
		int k;
		if (n < 0) {
			System.out.print("-1 ");
			n *= -1;
		}

		for (int i = 2; i <= n / i; i++) {
			k = 0;
			while (n % i == 0) {
				k++;
				n /= i;
			}
			if (k != 0) {
				if (k != 1)
					System.out.print(i + "^" + k);
				else
					System.out.print(i);
			}
		}
		if (n > 1)
			System.out.print(n);
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n =  10000;
		while (
			sc.hasNext() && 
			n-- > 0
		) {
			long x =  sc.nextLong();
			primalRepresentation(x);
		}
		sc.close();
	}
}
