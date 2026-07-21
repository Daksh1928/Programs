package LogicalThinking.EasyAndMedium;

import java.util.*;

public class Pattern10 {
    public static void sprint(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("#");
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

        for (int i = n; i > 0; i--) {
            sprint(i);
            System.out.println();
        }
        sc.close();
    }
}
