package exams;

import java.util.*;


public class DemoShoppeeThird {
    public static void main(String[] args) {

    }

    public static int[] SortSubStringToBuildPhoneNum(String phoneNum, String[] cardListArray) {
        int n = cardListArray.length;
        int[] res = new int[n];
        char[] phoneArr = phoneNum.toCharArray();
        Arrays.sort(phoneArr);
        String sortedPhone = new String(phoneArr);
        for(int i = 0; i < n; i++) {
            String card = cardListArray[i];
            char[] cardArr = card.toCharArray();
            boolean hasLetter = false;
            for (char c: cardArr) {
                if (Character.isLetter(c)) {
                    hasLetter = true;
                    break;
                }
            }
            if (hasLetter) {
                res[i] = -1;
                continue;
            }
            if (card.length() != phoneNum.length()) {
                res[i] = 0;
                continue;
            }
            Arrays.sort(cardArr);
            String sortedCard = new String(cardArr);
            res[i] = sortedCard.equals(sortedPhone) ? 1 : 0;
        }
        return res;
    }
}
