package LogicalThinking.EasyAndMedium;

import java.util.*;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(str.charAt(j) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
