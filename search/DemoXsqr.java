package search;

public class DemoXsqr {
    public static void main(String[] args) {

    }

    public static int solution(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 是先计算 mid*mid，再赋值给 cal 的，所以如果是 int 的 mid，那么要先转 long，作为 long 去接收结果，这样强转是可以的，相当于临时改变类型。这里的关键不是转型，而是范围
            long cal = (long) mid * mid;
            if (cal == x) {
                return mid;
            } else if (cal > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 返回 right
        return right;
    }
}
