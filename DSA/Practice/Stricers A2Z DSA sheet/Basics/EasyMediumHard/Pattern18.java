package LogicalThinking.EasyAndMedium;

import java.util.Scanner;

public class Pattern18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            for (char ch = (char) ('A' + rows - 1 - i); ch <= (char) ('A' + rows - 1); ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
