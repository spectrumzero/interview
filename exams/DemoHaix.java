package exams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DemoHaix {
    public static void main(String[] args) {

    }

    public static String solution(String s) {
        char[] chars = s.toCharArray();
        List<Character> lowerCaseList = new ArrayList<>();
        for (char c: chars) {
            if (Character.isLowerCase(c)) {
                lowerCaseList.add(c);
            }
        }
        Collections.reverse(lowerCaseList);
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                chars[i] = lowerCaseList.get(p);
                p++;
            }
        }
        return new String(chars);
    }
}
