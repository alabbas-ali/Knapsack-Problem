package Week3;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class AllCommonDividor {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int n = scan.nextInt();
        long[] integers = new long[n];
        //read the #n license plates integers[ 1 - 1000000000 ]
        for (int i = 0; i < n; i++) {
             integers[i] = scan.nextLong();
        }
        
        long[] res = allCommDiv(integers);
        for (int i = 0; i < res.length; i++) {
        	if(res[i] != 0) {
        		System.out.print(res[i] + " ");
        	}
        }
        scan.close();
	}
	
	static long[] allCommDiv(long[] arr) {
		
		long[] result = commDiv(arr[0], arr[1]);
		
		for(int i = 2; i < arr.length -1; i++) {
			long[] res = commDiv(arr[i], arr[i+1]);
			
			for(int j=0; j< result.length; j++) {
	            for(int k=0; k< res.length; k++) {
	                if(result[j] != res[k]){
	                	result[j] = 0;
	                }
	            }
	        }
		}
		
		return result;
	}
	
	// method to calculate all common divisors
    // of two given numbers
    // a, b --> input integer numbers
    static long[] commDiv(long a,long b) {
    	// find gcd of a,b
        long n = gcd(a, b);
        
		long[] results = new long[50000];
		// Count divisors of n.
		int j = 0;
		results[j] = n;
		for (long i = 1; i <= Math.sqrt(n); i++) {
			// if 'i' is factor of n
			if (n % i == 0) {
				// check if divisors are equal
				j++;
				results[j] = i;
			}
		}
		return Arrays.copyOfRange(results, 0, j);
    }
    
    public static long gcd(long p, long q) {
        while (q != 0) {
            long temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }
}
