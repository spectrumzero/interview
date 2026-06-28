package search;

import java.util.Random;
import java.util.Scanner;

public class DemoSort {
    public static Random random = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine().trim());
        String[] strs = scanner.nextLine().trim().split("\\s+");
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        sortEntry(nums);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(nums[i]);
            if (i != size - 1) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
        scanner.close();
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) return;
        }
    }




    // 合并 k 个链表，是返回一个链表。而这题，原地排序都能做到
    public static void sortEntry(int[] nums) {
    //  sort(nums, 0, nums.length - 1);
        quicSort(nums, 0, nums.length - 1);
    }

    // 快排（双路）
    public static void quicSort(int[] nums, int left, int right) {
        // 递归的终止条件
        if (left >= right) {
            return;
        }
        int pivot = random.nextInt(left, right + 1);
        swap(nums, left, pivot);
        int pivotNum = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] < pivotNum) {
                i++;
            }

            while (i <= j && nums[j] > pivotNum) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
            i++;
            j--;
        }
        // 左区间做最后的交换
        swap(nums, j, left);
        // 基于 j 继续排
        quicSort(nums, left, j - 1);
        quicSort(nums, j + 1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // 归并排序
    public static void sort(int[] nums, int left, int right) {
        // 终止条件
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    // 类似合并两个有序数组，但只需要传入一个数组
    public static void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        // 合并 mid 两边的有序数组，[left, mid], [mid + 1, right]
        int i = left, j = mid + 1;
        int p = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[p] = nums[i];
                p++;
                i++;
            } else {
                tmp[p] = nums[j];
                p++;
                j++;
            }
        }
        // 剩下还有
        while (i <= mid) tmp[p++] = nums[i++];
        while (j <= right) tmp[p++] = nums[j++];

        // 得到排好序的 tmp[]，遍历，赋值给原数组即可，偏移量
        // 外面已经用了 i 和 j 了
        for (int k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }
}
