package exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DemoFun {
    public static void main(String[] args) {

    }
    public static boolean isStraight (ArrayList<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1, min = 15;
        for (Integer num: nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;

    }


}
