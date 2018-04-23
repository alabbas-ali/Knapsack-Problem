package Week2;

import java.util.Scanner;

public class ChineseRemainder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a, n, b, m, t = sc.nextInt();
		while (
				(t--) > 0 &&
				sc.hasNextInt() && 
				(a = sc.nextInt()) > 0 && 
				(n = sc.nextInt()) > 0 && 
				(b = sc.nextInt()) > 0 && 
				(m = sc.nextInt()) > 0 
		) {

			// K is the product of the mods
			int K = n * m;
			
			int s = euclidean(m, n)[0];
			int r = euclidean(n, m)[0];
			
			int d = gcdExtended(m, n, 1, 1);
			int w = gcdExtended(n, m, 1, 1);
			
			System.out.println(s + " " + r);
			System.out.println(d + " " + w);
			int x = 0;

			x = ((K / n) * a * s) + ((K / m) * b * r);

			x = leastPosEquiv(x, K);

			System.out.println(x + " " + K);
		}
		sc.close();
	}

	// extended Euclidean Algorithm
    public static int gcdExtended(int a, int b, int x, int y)
    {
        // Base Case
        if (a == 0)
        {
            x = 0;
            y = 1;
            return b;
        }
 
        int x1=1, y1=1; // To store results of recursive call
        int gcd = gcdExtended(b%a, a, x1, y1);
 
        // Update x and y using results of recursive
        // call
        x = y1 - (b/a) * x1;
        y = x1;
 
        return gcd;
    }
    
	/*
	 * performs the Euclidean algorithm on a and b to find a pair of coefficients
	 * (stored in the output array) that correspond to x and y in the equation ax +
	 * by = gcd(a,b) constraint: a > b
	 */
	public static int[] euclidean(int a, int b) {
		if (b > a) {
			// reverse the order of inputs, run through this method, then reverse outputs
			int[] coeffs = euclidean(b, a);
			int[] output = { coeffs[1], coeffs[0] };
			return output;
		}

		int q = a / b;
		// a = q*b + r --> r = a - q*b
		int r = a - q * b;

		// when there is no remainder, we have reached the gcd and are done
		if (r == 0) {
			int[] output = { 0, 1 };
			return output;
		}

		// call the next iteration down (b = qr + r_2)
		int[] next = euclidean(b, r);

		int[] output = { next[1], next[0] - q * next[1] };
		return output;
	}

	// finds the least positive integer equivalent to a mod m
	public static int leastPosEquiv(int a, int m) {
		// a eqivalent to b mod -m <==> a equivalent to b mod m
		if (m < 0)
			return leastPosEquiv(a, -1 * m);
		// if 0 <= a < m, then a is the least positive integer equivalent to a mod m
		if (a >= 0 && a < m)
			return a;

		// for negative a, find the least negative integer equivalent to a mod m
		// then add m
		if (a < 0)
			return -1 * leastPosEquiv(-1 * a, m) + m;

		// the only case left is that of a,m > 0 and a >= m

		// take the remainder according to the Division algorithm
		int q = a / m;

		/*
		 * a = qm + r, with 0 <= r < m r = a - qm is equivalent to a mod m and is the
		 * least such non-negative number (since r < m)
		 */
		return a - q * m;
	}

}
