package exams;

import java.util.Scanner;

public class DemoExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int res = cal(s);
        System.out.println(res);
        scanner.close();
    }


    public static int cal(String s) {
        String[] expressions = s.split("@");
        int res = 0;
        for (String ex: expressions) {
            String[] subExp = ex.split("#");
            int[] digits = new int[subExp.length];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = Integer.parseInt(subExp[i]);
            }
            int tmp = digits[0];
            for (int i = 1; i < digits.length; i++) {
                tmp = tmp - (tmp & digits[i]);
            }
            res += tmp;
        }
        return res;
    }
}
