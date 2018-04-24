package Week2;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

class PrimePath {

    static boolean[] isPrime = getPrimes(10000);

    public static boolean[] getPrimes(int n) {
        int i, j, k, x;
        boolean[] a = new boolean[n];
        n++;
        n /= 2;
        int[] b = new int[(n + 1) * 2];
        a[2] = true;
        a[3] = true;
        for (i = 1; i <= 2 * n; i++) {
            b[i] = 0;
        }
        for (i = 3; i <= n; i += 3) {
            for (j = 0; j < 2; j++) {
                x = 2 * (i + j) - 1;
                while (b[x] == 0) {
                    a[x] = true;
                    for (k = x; k <= 2 * n; k += x) {
                        b[k] = 1;
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int cas = scan.nextInt();
        for (int i = 1; i <= cas; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            boolean[] isVisited = new boolean[10000];
            int[] step = new int[10000];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(start);
            isVisited[start] = true;
            while (!queue.isEmpty()) {
                int current = queue.pop();
                if (current == end) {
                    break;
                }
                for (int j = 0; j <= 9; j++) {
                    int next1 = getNext(1, j, current);
                    int next2 = getNext(2, j, current);
                    int next3 = getNext(3, j, current);
                    int next4 = getNext(4, j, current);
                    if (!isVisited[next1]) {
                        queue.addLast(next1);
                        step[next1] = step[current] + 1;
                        isVisited[next1] = true;
                    }
                    if (!isVisited[next2]) {
                        queue.addLast(next2);
                        step[next2] = step[current] + 1;
                        isVisited[next2] = true;
                    }
                    if (!isVisited[next3]) {
                        queue.addLast(next3);
                        step[next3] = step[current] + 1;
                        isVisited[next3] = true;
                    }
                    if (!isVisited[next4]) {
                        queue.addLast(next4);
                        step[next4] = step[current] + 1;
                        isVisited[next4] = true;
                    }
                }
            }
            System.out.println(step[end]);
        }
        scan.close();
    }

    public static int getNext(int flag, int i, int current) {
        int next = 0;
        if (flag == 1) {
            if (i == 0) {
                return current;
            }
            next = current % 1000 + i * 1000;
        }
        if (flag == 2) {
            int t = current / 1000;
            next = t * 1000 + current % 1000 % 100 + i * 100;
        }
        if (flag == 3) {
            int t = current / 100;
            int tt = current % 10;
            next = t * 100 + i * 10 + tt;
        }
        if (flag == 4) {
            next = current / 10 * 10 + i;

        }
        if (!isPrime[next]) {
            return current;
        }
        return next;
    }

}