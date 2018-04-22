package Week2;

import java.util.Scanner;

public class HowManyDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1;
		int x;
		
		double[] ans = new double[10000000];
		ans[0] = 0;
		for (int i = 1; i < 10000000; i++) {
			ans[i] += ans[i - 1] + Math.log10(i);
		}
		
		while (
			sc.hasNextInt() && 
			(x = sc.nextInt()) >= 0 && 
			++n <= 10000
		) {
			System.out.println((int) ans[x] + 1);
		}
		sc.close();
	}

}
