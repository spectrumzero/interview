package exams;

import java.util.Scanner;

public class DemoMeidiTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] indexCols = scanner.nextLine().trim().split(",");
        String[] whereCols = scanner.nextLine().trim().split(",");
        String[] hasRange = scanner.nextLine().trim().split(",");
        int index = 0, where = 0, range = 0;
        int res = 0;
        for (int i = 0; i < whereCols.length; i++) {
            if (whereCols[i].equals(indexCols[index])) {
                res++;
                index++;
                if (hasRange[range].equals("false")) {
                    range++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println(res);

    }
}
