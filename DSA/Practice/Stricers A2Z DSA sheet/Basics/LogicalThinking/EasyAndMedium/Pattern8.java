package LogicalThinking.EasyAndMedium;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String... agrs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        for (int i = n; i >=0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
