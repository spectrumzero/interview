package exams;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class DemoXinKaiLai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] res = solution(nums, k);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            stringBuilder.append(res[i]);
            if (i != res.length - 1) {
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder);


    }

    public static int[] solution(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for (int i = 1; i + k - 1 < n; i++) {
            if (deque.peekFirst() == i - 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i + k - 1] >=  nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i + k - 1);
            res[i] = nums[deque.peekFirst()];
        }
        return res;
    }
}
