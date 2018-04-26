package Week2;

import java.util.Scanner;

public class Cantor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x;
		boolean belong = false;
		while (sc.hasNext()) {
			x = sc.nextLine();
			if(x.equals("END")) {
				break;
			}
			double r = Double.parseDouble(x);
			for (int m = 1; m <= 7; m++) {
				if(belongsToSet(m,r)) {
					belong = true;
				}
			}
			if(belong) {
				System.out.println("MEMBER");
			}else {
				System.out.println("NON-MEMBER");
			}
		}
		sc.close();
	}

	public static boolean belongsToSet(int m, double x) {
		double line = 1024;
		double x1, x2;
		for (int mm = 1; mm < m; mm++) {
			for (int k = 0; k < (int) ((Math.pow(3, (mm - 1))) - 1 + 1); k++) {
				x1 = (3.0 * k + 1) / Math.pow(3.0, mm);
				x2 = (3.0 * k + 2) / Math.pow(3.0, mm);
				if ((x > x1 * line) && (x < x2 * line))
					return false;
			}
		}
		return true;
	}
}
