package search;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class DemoTopK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(heapSort(nums, k));
        scanner.close();
    }

    // 快排，双路快速排序的一种变种，快速选择
    // O(n) 的时间复杂度：n + n/2 + n/4……

    public static Random random = new Random();

    public static int quicSort(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int targetIndex = nums.length - k;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index == targetIndex) {
                return nums[index];
            } else if (index < targetIndex) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return nums[targetIndex];
    }

    public static int partition(int[] nums, int left, int right) {
        int randIndex = random.nextInt(left, right + 1);
        int pivot = nums[randIndex];
        swap(nums, left, randIndex);
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] > pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
            i++;
            j--;
        }
        // 记得要换回来
        swap(nums, left, j);
        // 无需递归（完整快排 nlogn），因为我只需要一个位置正确。
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // 堆排法。使用外部库，即优先队列，时间复杂度确实是 nlogn，但是空间不如原生数组的 inplace 堆排O(1)，而是 O(n)。
    public static int heapSort(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                // logN 的时间复杂度：取出堆顶O1 -> 把堆底的最后一个元素放到堆顶O1 -> 向下调整logN。
                heap.poll();
            }
        }
        return heap.peek();
    }
}
