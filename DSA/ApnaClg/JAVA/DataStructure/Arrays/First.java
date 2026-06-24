package DataStructure.Arrays;

import java.util.Scanner;

public class First {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        // int[] arr = new int[10];
        // arr[0] = 10;
        // arr[1] = 20;
        // arr[2] = 30;
        // arr[3] = 40;
        // arr[4] = 50;
        // arr[5] = 60;
        // arr[6] = 70;
        // arr[7] = 80;
        // arr[8] = 90;
        // arr[9] = 100;
        // for (int n : arr) {
        // if (n > 50) {
        // System.out.println(n);
        // }
        // }
        // // for (int i = 0; i < arr.length; i++) {
        // // arr[i] = i + 10;
        // // }
        // // for (int n : arr) {
        // // System.out.println(n);
        // // }
        int[] arr = { 1, 4, 3, 2, 56, 78, 75, 21, 34 };
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println("Select the target number you wanna know the index of : ");
        int target = sc.nextInt();
        int s = 0;
        for (int n : arr) {

            if (n == target) {
                System.out.println("The index of " + target + " is :" + s);
            } else {
                s++;
            }
        }

    }
}
