package simulation;

public class DemoReverseWords {
    public static void main(String[] args) {

    }

    // 翻转字符串中的单词：" hello world " -> "world hello"
    public static String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        // 必须要 trim 并返回。s 是不可变的。
        s = s.trim();
        int start = s.length() - 1, end = s.length() - 1;
        while (start >= 0) {
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            // start + 1 是确认同时满足条件的
            stringBuilder.append(s.substring(start + 1, end + 1));
            // 继续把 start 移动到新的位置：要么此时已经遍历完字符串，start 为负数，要么此时 start 站在一个新的非空格字符的起点上
            while (start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            // 如果不是最后一个段，需要 append 一个空格。
            if (start >= 0) {
                stringBuilder.append(" ");
            }
            // 更新边界
            end = start;
        }
        return stringBuilder.toString();
    }


}
