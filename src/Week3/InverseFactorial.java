package Week3;

import java.math.BigInteger;
import java.util.Scanner;

public class InverseFactorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger n = scan.nextBigInteger();
        System.out.print(invfact(n));
        scan.close();
	}
	
	public static BigInteger invfact(BigInteger n) {
		BigInteger f = new BigInteger("1");
		while (n.compareTo(f) == 1){
			n = n.divide(f);
			f.add(BigInteger.ONE);
		}
		return f;
	}

}
