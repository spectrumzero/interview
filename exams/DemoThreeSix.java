package exams;

import java.awt.image.CropImageFilter;
import java.util.Arrays;
import java.util.Scanner;

public class DemoThreeSix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] goods = new int[n];
        int[] packages = new int[m];
        for (int i = 0; i < n; i++) {
            goods[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            packages[i] = scanner.nextInt();
        }
        // 包裹从小到大
        Arrays.sort(packages);
        int sum = 0;
        for (int good: goods) {
            // 找一个刚好大于 good 要求的包裹，并返回该包裹的重量
            int index = find(packages, good);
            if (index >= m) {
                System.out.println("-1");
                return;
            }
            sum += packages[index];
        }
        System.out.println(sum);
    }

    public static int find(int[] packages, int target) {
        int left = 0, right = packages.length - 1;
        int ans = packages.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (packages[mid] == target) {
                return mid;
            } else if (packages[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }




}
