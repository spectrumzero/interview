package exams;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class DemoMai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int T = in.nextInt(), H = in.nextInt();
        int[] happy = new int[n];
        while (in.hasNext()) {
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    happy[i] = in.nextInt();
                    continue;
                }
                in.nextInt();
            }
        }
        Arrays.sort(happy);


    }
}