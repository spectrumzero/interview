package exams;

import java.util.Scanner;

public class DemoVivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            int[] state = new int[n + 1];
            int[] lastTime = new int[n + 1];
            for (int i = 1; i <= m; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                for (int j = l; j <= r; j++) {
                    if (lastTime[j] == 0) {
                        lastTime[j] = i;
                    } else {
                        int p = lastTime[i];
                        if (i - p <= d) {
                            state[j] = 1 - state[j];
                            lastTime[j] = 0;
                        } else {
                            lastTime[j] = i;
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                stringBuilder.append(state[i]).append(i == n ? "" : " ");
            }
            System.out.println(stringBuilder);
        }
        scanner.close();

    }


}
