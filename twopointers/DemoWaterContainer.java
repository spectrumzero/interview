package twopointers;

public class DemoWaterContainer {
    public static void main(String[] args) {

    }

    // 盛最多水的容器
    public static int solution(int[] heights) {
        int left = 0, right = heights.length - 1;
        int res = 0;
        while (left <= right) {
            int width = right - left;
            if (heights[left] >= heights[right]) {
                res = Math.max(res, width * heights[right]);
                right--;
            } else {
                res = Math.max(res, width * heights[left]);
                left++;
            }
        }
        return res;
    }
}
