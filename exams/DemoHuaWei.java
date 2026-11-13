package exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DemoHuaWei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] must = new int[n];
        int origin = 0;
        for (int i = 0; i < n; i++) {
            must[i] = scanner.nextInt();
            origin += must[i];
        }
        int[] addons = new int[m];
        for (int i = 0; i < m; i++) {
            addons[i] = scanner.nextInt();
        }
        Arrays.sort(addons);
        List<int[]> absolute = new ArrayList<>();
        List<int[]> ratio = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.nextInt() == 0) {
                absolute.add(new int[] {scanner.nextInt(), scanner.nextInt()});
            } else {
                ratio.add(new int[] {scanner.nextInt(), scanner.nextInt()});
            }
        }

        System.out.println(origin);

    }
}
