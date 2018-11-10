package ProgrammingDay;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class InfiniteSlides {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		double cas = scan.nextDouble();
		
		System.out.println(Math.sqrt(cas));
		
		scan.close();

	}

}
