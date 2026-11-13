package exams;

import java.util.Scanner;

public class DemoThreeSixTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start_price = scanner.nextInt(), price = scanner.nextInt(), start_minute = scanner.nextInt();
        int n = scanner.nextInt();
        int[] roads = new int[n];
        int base = 0;
        for (int i = 0; i < n; i++) {
            roads[i] = scanner.nextInt();
            base += roads[i];
        }
        int addons = 0;
        int[] lights = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            lights[i] = scanner.nextInt();
            addons += lights[i];
        }
        int total = base + addons;
        if (total <= start_minute) {
            System.out.println(start_price);
            return;
        } else {
            int total_price = start_price + (total - start_minute) * price;
            System.out.println(total_price);
            return;
        }



    }
}
