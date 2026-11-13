package search;

public class DemoDivideSort {
    public static void main(String[] args) {

    }

    public static void divideSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        // 终止条件
        if (left == right) {
            return;
        }
        // 二分
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        // 两个有序数组的区间分别为，[left, mid], [mid + 1, right]
        // 用指针 i, 和 j 来遍历，因为后面还是需要 left 来计算偏移量
        int i = left, j = mid + 1;
        int p = 0;
        // tmp 数组的长度不是关键的循环条件，所以 for 循环不够用；应该用 while 来表达真正关键的循环条件，避免 nums 边界溢出
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
        while (i <= mid)
            tmp[p++] = nums[i++];
        while (j <= right)
            tmp[p++] = nums[j++];

        // 得到排好序的 tmp[]，遍历，赋值给原数组即可，偏移量
        // 外面已经用了 i 和 j 了
        for (int k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }
}
