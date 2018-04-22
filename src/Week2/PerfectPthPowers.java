package Week2;

import java.io.IOException;
import java.util.Scanner;

public class PerfectPthPowers {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		long x;

		while (sc.hasNextInt() && (x = sc.nextInt()) != 0) {
			int length;
			boolean found = false;
			if (x < 0) {
				length = (int) Math.sqrt(x * -1);
				for (int i = -2; i >= -length; i--) {
					long ans = i;
					int p = 2;
					while (ans > x) {
						ans = (long) Math.pow(i, p);
						p++;
					}
					if (ans == x) {
						System.out.println(p - 1);
						found = true;
						break;
					}
				}
			} else {
				length = (int) Math.sqrt(x);
				for (int i = 2; i <= length; i++) {
					long ans = i;
					int p = 2;
					while (ans < x) {
						ans = (long) Math.pow(i, p);
						p++;
					}
					if (ans == x) {
						System.out.println(p - 1);
						found = true;
						break;
					}
				}
			}
			if(!found) System.out.println(1);
		}
		sc.close();
	}

}
