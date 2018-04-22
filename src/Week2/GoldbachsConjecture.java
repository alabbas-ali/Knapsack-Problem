package Week2;

import java.util.Scanner;

public class GoldbachsConjecture {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			if (x == 4) {
				System.out.println("4 has 1 representation(s)");
				System.out.println("2+2");
			} else {
				int[][] multi = new int[999][2];
				int end, start = 3, counter = 0;
				while (start <= (end = x - start)) {

					if (checkPrime(start) && checkPrime(end)) {
						multi[counter][0] = start;
						multi[counter][1] = end;
						counter++;
					}
					start += 2;
				}
				System.out.println(x + " has " + counter + " representation(s)");
				for (int j = 0; j < counter; j++) {
					System.out.println(multi[j][0] + "+" + multi[j][1]);
				}
			}
		}
		sc.close();
	}

	static boolean checkPrime(int number) {
		if (number < 2)
			return false;
		if (number % 2 == 0)
			return (number == 2);
		int root = (int) Math.sqrt((double) number);
		for (int i = 3; i <= root; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}
