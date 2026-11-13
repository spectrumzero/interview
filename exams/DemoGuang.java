package exams;

import java.util.Arrays;
import java.util.Scanner;

public class DemoGuang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] numsA = new int[n];
            int[] numsB = new int[n];
            for (int i = 0; i < n; i++) {
                numsA[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                numsB[i] = scanner.nextInt();
            }
            boolean res = solution(numsA, numsB);
            if (res) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }

    public static boolean solution(int[] numsA, int[] numsB) {
        Arrays.sort(numsA);
        Arrays.sort(numsB);
        for (int i = 0; i < numsA.length; i++) {
            int diff = numsB[i] - numsA[i];
            if (diff < 0 || diff > 1) {
                return false;
            }
        }
        return true;

    }
}
