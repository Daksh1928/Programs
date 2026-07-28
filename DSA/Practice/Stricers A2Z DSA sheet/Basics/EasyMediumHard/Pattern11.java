package LogicalThinking.EasyAndMedium;

import java.util.*;

public class Pattern11 {
    public static void sprint(int i) {
        for (int j = 0; j < i; j++) {
            if (j % 2 == 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sprint(i);
            System.out.println();
        }
        sc.close();
    }
}
