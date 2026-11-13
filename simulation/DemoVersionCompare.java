package simulation;

public class DemoVersionCompare {
    public static void main(String[] args) {

    }

    public static int solution(String version1, String version2) {
        int p1 = 0, p2 = 0;
        // 不应该是 &&，因为退出的时候还是不能确定结果。
        while (p1 < version1.length() || p2 < version2.length()) {
            int tmp1 = 0;
            int tmp2 = 0;
            while (p1 < version1.length() && version1.charAt(p1) != '.') {
                // 要 - '0' 转数字
                tmp1 = tmp1 * 10 + version1.charAt(p1) - '0';
                p1++;
            }
            // 记得跳过点号，不然是死循环了
            p1++;
            while (p2 < version2.length() && version2.charAt(p2) != '.') {
                tmp2 = tmp2 * 10 + version2.charAt(p2) - '0';
                p2++;
            }
            // 同理
            p2++;
            if (tmp1 < tmp2) {
                return -1;
            } else if (tmp1 > tmp2) {
                return 1;
            }
        }
        return 0;
    }

    // 其它注意事项
    public static int solutionTwo(String version1, String version2) {
        // 如 . | * + ? ^ $ [ ] ( ) {} \ 都是需要转义符号 `\\` 的，后面加上对应的字符即可
        // 空格类型，包括制表\t、空格 、换行\n、回车\r，一般统一用 `\\s+` 来处理。
        String[] segs_1 = version1.split("\\.");
        String[] segs_2 = version2.split("\\.");
        // 选择最长的那个，不能提前退出因为我们还不能获知结果
        int n = Math.max(segs_1.length, segs_2.length);
        for (int i = 0; i < n; i++) {
            // 无效补 0 即可
            int tmp1 = i < segs_1.length ? Integer.parseInt(segs_1[i]) : 0;
            int tmp2 = i < segs_2.length ? Integer.parseInt(segs_2[i]) : 0;
            if (tmp1 == tmp2) {
                continue;
            }
            return tmp1 < tmp2 ? -1 : 1;
        }
        return 0;
    }
}
