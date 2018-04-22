package Week2;

import java.util.Scanner;

public class HowMany0s {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x, y, n = 15000;
		while (
				sc.hasNextLong() && 
				(x = sc.nextLong()) != -1 && 
				(y = sc.nextLong()) >= -1 && 
				n-- > 0
		) {
			long count1 = x == 0 ? 0 : numZeroesFromZero(x-1);
			long count2 = numZeroesFromZero(y);
			System.out.println(count2 - count1);
		}
		sc.close();
	}
	
	/* 
	* Returns the number of zeroes in all natural numbers in the interval 0-x 
	*/ 
	private static long numZeroesFromZero(long x) {
		long a = 0, b = 0, c = 0;
		int digits = numDigits(x);
		for (int i = digits - 1; i >= 0; --i) {
			// loop over all digits, left to right.
			int digit = (int) ((x / (int) Math.pow(10, i)) % 10);
			a = (10 * a + b - c * (9 - digit));
			// main formula. the count of each digit is periodic
			if (digit == 0) {
				++c;
			}
			b = (10 * b + digit);
		}
		return a + 1;
	}
	
	private static int numDigits(long number) { 
		int digits = 0; 
		while (number != 0) { 
			number /= 10; 
			++digits; 
		} 
		return digits; 
	} 

	
}
