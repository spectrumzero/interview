package exams;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DemoBuyHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        int[][] houses = new int[m][];
        for (int i = 0; i < m; i++) {
            houses[i] = new int[] {scanner.nextInt(), scanner.nextInt()};
        }
        System.out.println(sum(houses, coins));

        scanner.close();
    }

    public static int sum(int[][] houses, int[] coins) {
        int res = 0;
        // 舒适度倒序
        Arrays.sort(houses, (a, b) -> b[0] - a[0] );
        // 有钱人升序
        Arrays.sort(coins);

        // 大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> houses[b][0] - houses[a][0]);
        for (int i = 0; i < houses.length; i++) {
            heap.offer(i);
        }
        while (!heap.isEmpty()) {
            int[] besthouse = houses[heap.poll()];
            int comf = besthouse[0];
            int price = besthouse[1];
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] >= price) {
                    res += comf;
                    coins[i] = 0;
                    break;
                }
            }
        }
        return res;


    }
}
