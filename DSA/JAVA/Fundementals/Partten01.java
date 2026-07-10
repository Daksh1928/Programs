import java.util.*;

public class Partten01 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of row : ");
        int row = sc.nextInt();
        System.out.print("Enter number of column : ");
        int coln = sc.nextInt();

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= coln; j++) {
                if (i == 0 || j == 0 || i == row || j == coln) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}