package Week3;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;

public class ChineseReminder {
	private static Scanner in;

	public static void main(String[] args) {
		int T;
		long a,m,b,n,d,l;
		in = new Scanner(System.in);
		T = in.nextInt();
		while (T>0){
			T--;
			a = in.nextLong();
			n = in.nextLong();
			b = in.nextLong();
			m = in.nextLong();
			
			d = gcd(n,m);
			l = n * m / d;
			
			if (a % d != b % d){
				System.out.println("no solution");
			}
			else { // prime factorization and ...
				m /= d;
				long ll = Math.max(n, m);
				m = Math.min(n, m);				
				Vector res = new Vector();
				Vector N = new Vector();
				for (long i = 2 ; i < Math.sqrt(ll) ; i++){
					long temp = 1;
					while (ll % i == 0){
						temp *= i;
						ll /= i;
					}
					while (m % i == 0){
						temp *= i;
						m /= i;
					}
					if (temp != 1){
						res.add(temp);
						N.add(temp);
					}
				}
				if (ll > 1) {
					res.add(ll);
					N.add(ll);
				}
				if (m > 1) {
					res.add(m);
					N.add(m);
				}

				// create N and N_i						
				
				for (int i=0 ;i<res.size();i++){					
					N.set(i, l / (long)res.get(i));
				}
				
				Vector<BigInteger> NN = new Vector<BigInteger>();
				Vector<BigInteger> ress = new Vector<BigInteger>();
				for (int i=0;i<res.size();i++){
					NN.add(new BigInteger(N.get(i) + ""));
					ress.add(new BigInteger(res.get(i) + ""));
				}
				BigInteger L = new BigInteger(l+"");
				BigInteger A = new BigInteger(a+"");
				BigInteger B = new BigInteger(b+"");
				// set x
				BigInteger x = BigInteger.ZERO;
				for (int i=0;i<res.size();i++){
					if (n % (long)res.get(i) != 0)
						x = x.add((B.multiply(NN.get(i).multiply(mod_inv(NN.get(i), ress.get(i))))).mod(L));
					else
						x = x.add((A.multiply(NN.get(i).multiply(mod_inv(NN.get(i), ress.get(i))))).mod(L));
				}

				x = x.mod(L);

				System.out.println(x + " " + l);
			}
		}		
		
	}
	
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private static BigInteger mod_inv(BigInteger m, BigInteger n) {
	    BigInteger bb = n, temp, q;
	    BigInteger x0 = BigInteger.ZERO;
	    BigInteger x1 = BigInteger.ONE;
	    if (n.equals(1)) return BigInteger.ONE;
	    while (m.compareTo(BigInteger.ONE) > 0) { // m > 1
	        q = m.divide(n);
	        temp = n; n = m.mod(n); m = temp;
	        temp = x0; x0 = x1.add(q.multiply(x0).negate()); x1 = temp;
	    }
	    if (x1.compareTo(BigInteger.ZERO) < 0) x1 = x1.add(bb);
	    return x1;
	}
}
