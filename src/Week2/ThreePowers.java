package Week2;

import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;

public class ThreePowers {

	public static String toBin(BigInteger num) {
		// convert to binary
		return num.toString(2);
	}

	public static void main(String[] args) {

		ArrayList<BigInteger> powers3 = new ArrayList<>();
		powers3.add(BigInteger.ONE);
		
		// init upto power 65
		for (int i = 1; i < 65; i++) {
			powers3.add(powers3.get(i - 1).multiply(BigInteger.valueOf(3)));
		}
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				BigInteger bigS = new BigInteger(scanner.next());
				// logic is tough to crack
				if (bigS.equals(BigInteger.ZERO))
					break;

				bigS = bigS.subtract(BigInteger.ONE);

				if (bigS.equals(BigInteger.ZERO))
					System.out.println("{ }");
				else {
					// covert to binary
					String str = toBin(bigS);
					str = new StringBuffer(str).reverse().toString();
					System.out.print("{ ");
					for (int i = 0; i < str.length(); i++) {
						// if the bit is one print
						if (str.charAt(i) == '1') {
							if (i == str.length() - 1)
								System.out.print(powers3.get(i));
							else
								System.out.print(powers3.get(i) + ", ");
						}

					}

					System.out.println(" }");
				}
			}
		}

	}
}
