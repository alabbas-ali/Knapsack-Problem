package Week2;

import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;

public class ThreePowers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<BigInteger> powers3 = new ArrayList<>();
		powers3.add(BigInteger.ONE);

		// initialize up to power 65
		for (int i = 1; i < 65; i++) {
			powers3.add(powers3.get(i - 1).multiply(BigInteger.valueOf(3)));
		}
		
		BigInteger x;
		
		while (
			sc.hasNext() &&
			!(x = new BigInteger(sc.next())).equals(BigInteger.ZERO)
		) {
			
			x = x.subtract(BigInteger.ONE);

			if (x.equals(BigInteger.ZERO))
				System.out.println("{ }");
			else {
				// covert to binary
				String str = x.toString(2);
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
		sc.close();
	}
}
