package LogicalThinking.EasyAndMedium;

import java.util.Scanner;

public class Pattern15 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows under 26 : ");
        int n = sc.nextInt();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
        sc.close();

    }
}
