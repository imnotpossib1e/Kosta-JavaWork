package test;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();

            int result = 0;

            for (int i = m1; i <= m2; i++) {
                if (i == m1) {
                    if (m1 == 2) {
                        result = 28 - d1 + 1;
                    } else if (m1 == 4 || m1 == 6 || m1 == 9 || m1 == 11) {
                        result = 30 - d1 + 1;
                    } else {
                        result = 31 - d1 + 1;
                    }
                } else if (i == m2) {
                    result += d2;
                } else {
                    if (i == 2) {
                        result += 28;
                    } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                        result += 30;
                    } else {
                        result += 31;
                    }

                }
            }

            System.out.printf("#%d %d\n", t, result);
        }
    }
}
