package Week3;

import java.util.Scanner;

public class RationalArithmetic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			Rational x = new Rational(sc.nextLong(), sc.nextLong());
			String op = sc.next();
			Rational y = new Rational(sc.nextLong(), sc.nextLong());

			switch (op) {
			case "+":
				System.out.println(x.add(y));
				break;
			case "-":
				System.out.println(x.subtract(y));
				break;
			case "/":
				System.out.println(x.divide(y));
				break;
			case "*":
				System.out.println(x.multiply(y));
				break;
			}

		}

		sc.close();
	}	

}

