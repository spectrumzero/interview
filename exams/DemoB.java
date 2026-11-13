package exams;

import java.util.Scanner;

public class DemoB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt(), k = scanner.nextInt();
            String str = scanner.next();
            System.out.println(str.length());
        }

    }
}
