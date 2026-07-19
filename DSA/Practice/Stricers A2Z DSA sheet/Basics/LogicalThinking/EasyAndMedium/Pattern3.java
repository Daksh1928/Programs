package LogicalThinking.EasyAndMedium;

import java.util.*;

public class Pattern3 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" " + j);

            }
            System.out.println();
        }
        sc.close();
    }
}
