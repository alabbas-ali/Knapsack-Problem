package Week3;

import java.util.Scanner;

public class Granica {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] integers = new long[n];
        //read the #n license plates integers[ 1 - 1000000000 ]
        for (int i = 0; i < n; i++) {
             integers[i] = scan.nextLong();
        }
        
        long min = integers[0];
        int index = 0;
        
        for (int i = 1; i < integers.length; i++) { 
        	if(integers[i] < min) {
        		min = integers[i];
        		index = i;
        	}
        }
        
        boolean addit;
        for(long i = 2; i < min; i++) {
        	addit = true;
        	for (int j = 1; j < integers.length; j++) { 
            	if( index != j && 
            		min % i != integers[j] % i
            	) {
            		addit = false;
            	}
            }
        	if(addit) {
        		System.out.print(i + " ");
        	}
        }
        
        scan.close();
	}
	
}
