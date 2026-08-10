package simulation;

public class DemoAddString {
    public static void main(String[] args) {

    }

    // 字符串相加，低位到高位。cur 只是存储方式。
    public static String solution(String num1, String num2) {
        StringBuilder cur = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int op1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int op2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = op1 + op2 + carry;
            cur.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return cur.reverse().toString();
    }
}
