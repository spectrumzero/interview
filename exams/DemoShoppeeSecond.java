package exams;
import java.util.*;

public class DemoShoppeeSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        String res = solution(input[0], input[1]);
        System.out.println(res);
    }

    public static String solution(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.substring(i).compareTo(word2.substring(j)) >= 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        if (i < word1.length()) {
            merge.append(word1.substring(i));
        }
        if (j < word2.length()) {
            merge.append(word2.substring(j));
        }
        return merge.toString();
    }
}
