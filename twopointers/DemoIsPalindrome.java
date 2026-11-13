package twopointers;

public class DemoIsPalindrome {
    public static void main(String[] args) {
    }


    // 验证回文串
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            // 有小写返回小写，没有就返回原值
            char lc = Character.toLowerCase(s.charAt(left));
            char rc = Character.toLowerCase(s.charAt(right));
            // A-Z, a-z, 0-9
            // ps: letter 其实很广泛（alpha 更是）。但 letter 不包括 1, 2 等数字的（alpha 也是一样）。
            if (!Character.isLetterOrDigit(lc)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rc)) {
                right--;
                continue;
            }
            // 到了这个条件才比较
            if (lc != rc) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
