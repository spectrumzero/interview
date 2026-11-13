package search;

import java.util.Random;

public class DemoQuicSort {
    public static void main(String[] args) {

    }

    // 避免每次都选择到极值，每次递归的切分效率退化，时间复杂度到了 n2。
    public static Random random = new Random();

    public static void quicSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        // 递归的终止条件，不要老是忘记写
        if (left >= right) {
            return;
        }
        // 左闭右开的区间
        int pivot = random.nextInt(left, right + 1);
        int pivotNum = nums[pivot];
        // 传入的后面两个参数是索引哈
        swap(nums, left, pivot);
        // 扫描指针，负责两个区域。把 pivotNum 固定放在最左边的原因，是为了让这两个区间的边界划分更明确，而且避免交换中丢失 pivotNum 的位置 j
        int i = left + 1;
        int j = right;
        // 等于的时候也要处理判断，这剩下的一个元素属于哪一个区域
        while (i <= j) {
            // 小于 pivotNum 的区域
            while (i <= j && nums[i] < pivotNum) {
                i++;
            }

            // 大于 pivotNum 的区域
            while (i <= j && nums[j] > pivotNum) {
                j--;
            }

            // > 无效，= 侧面表示该元素等于 pivotNum，这种情况也无需多余的交换处理
            if (i >= j) {
                break;
            }

            swap(nums, i, j);
            // 交换后记得更新指针
            i++;
            // j 是 pivotNum 的最后位置，在较小的区域那里去了
            // 但此时 j 不是 pivotNum，只是标记成功。这个时候 j 的值是属于左区间的一个值
            j--;
        }
        // 左区间做最后的交换，把 pivotNum 从 left 换到 j 的索引位置，这个时候 left 索引上的值的范围也正确
        swap(nums, j, left);
        // 基于 j 继续排。[left, j - 1] 一定比 pivot 小，[j + 1, right] 一定比 pivot 大，这样类似二分
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
