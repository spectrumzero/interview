package exams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DemoShaoTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().trim();
        boolean res = solution(input);
        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static boolean solution(String num) {
        int[] mapping = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            mapping[i] = num.charAt(i) - '0';
        }
        for (int i = 0; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                int op1 = mapping[0];
                for (int k = 1; k <= i; k++) {
                    op1 *= mapping[k];
                }
                int op2 = mapping[j];
                for (int q = j + 1; q <= num.length() - 1; q++) {
                    op2 *= mapping[q];
                }
                if (op1 == op2) {
                    return true;
                }
            }
        }
        return false;


    }
}
