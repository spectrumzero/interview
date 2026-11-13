package exams;

import java.util.Arrays;
import java.util.Scanner;

public class DemoHuaWeiThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] buildings = new int[n];
        int[] bombs = new int[m];
        for (int i = 0; i < n; i++) {
            buildings[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            bombs[i] = scanner.nextInt();
        }
        Arrays.sort(bombs);
        int res = 0;
        for (int i = 0; i < 1; i++) {
            res += bombs[i];
        }
        System.out.println(res);

    }

}
