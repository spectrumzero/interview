package search;

public class DemoRotatedMin {
    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            } else { // 否则代表左边已经有峰值，右边是递增的，从 mid 开始
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }
        }
        return res;
    }
}
