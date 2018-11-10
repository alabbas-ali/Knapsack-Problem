package ProgrammingDay;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Password {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		
		int A = scan.nextInt();
		
		int B = scan.nextInt();
		
		int N = scan.nextInt();
		double total = 0;
		List<Double> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] s = scan.nextLine().split(" ");
			list.add(Double.parseDouble(s[1]));
		}
		Collections.sort(list);
		
		Collections.reverse(list);
		
		for (int i = 0; i < N; i++) {
			total += list.get(i) * (i + 1);
		}
		System.out.println(total);

		scan.close();
	}
}
