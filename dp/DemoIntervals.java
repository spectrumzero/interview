package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 合并区间
public class DemoIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine().trim());
        int[][] intervals = new int[length][];
        for (int i = 0; i < length; i++) {
            intervals[i] = new int[] {scanner.nextInt(), scanner.nextInt()};
        }
        int[][] res = merge(intervals);
        for (int[] nums: res) {
            System.out.println(nums[0] + " " + nums[1]);
        }
        scanner.close();
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        // 二维数组要注意
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                res.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[] {start, end});
        // 这里。不要默认 Object[]，而是要明确转变为的数组和大小
        // 以及 res 中的元素得是 int[]，而不是 List<>，才能这样转
        return res.toArray(new int[res.size()][]);
        // return res.toArray(new int[res.size()][]);
    }
}
