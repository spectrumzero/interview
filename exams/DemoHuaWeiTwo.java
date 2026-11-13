package exams;

import java.util.Scanner;

public class DemoHuaWeiTwo {

    public static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.next();
            }
        }
        int res = -1;
        if (matrix[0][0].equals("x")) {
            res = 1;
        } else if (matrix[0][0].equals("1")) {
            res = 2;
        } else {
            res = 0;
        }
        System.out.println(res);




    }

}
