package exams;

import java.util.Scanner;

public class DemoHaixTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] nums = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            total += nums[i];
        }
        System.out.println(total);
    }


}
