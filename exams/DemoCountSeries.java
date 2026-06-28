package exams;

import java.util.Scanner;

public class DemoCountSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long combinations = (long) Math.pow(3, n);
            long res = (combinations - 7) % 10000000007l;
            stringBuilder.append(res);
            if (i != t - 1) stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
        scanner.close();
    }
}
