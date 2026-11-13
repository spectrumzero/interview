package search;

public class DemoBubbleSort {
    public static void main(String[] args) {

    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        // 外层控制循环次数，如果有 n 个元素，那么如果能确定 n - 1 个元素的位置，最后一个位置就无需确定
        // 事实上，冒泡的过程，是依次确定最大值到最小值的过程。外层循环一次，就可以确定一个最大值，确定 n - 1 个值即可
        // [1, 2, 4, 5, 9, 3, 0]
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            // 内层每次都从头开始，向后比较
            // i 的语义其实是，当前已经确定了多少个元素的位置，因此到该元素的位置就不用再向后了
            // 故第一次遍历，需要比较到所有元素，包括最后一个元素
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    swapped = true;
                }
            }
            // 所以，如果没有发生交换，代表所有的最大值已经落好。剪枝，直接返回即可
            if (!swapped) return;
        }
    }
}
