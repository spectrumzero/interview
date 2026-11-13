package exams;

import java.util.Arrays;
import java.util.Scanner;

public class DemoDiDiSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), k = scanner.nextInt();
        int[][] flowers = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                flowers[i][j] = scanner.nextInt();
            }
        }
        Arrays.sort(flowers, (a, b) -> b[1]- a[1]);
        int point = 0;
        for (int i = 0; i < k; i++) {
            if (i < flowers.length) {
                point += flowers[i][1];
            } else {
                point += flowers[0][1];
            }
        }
        point += k*k;
        System.out.println(point);
    }
}
