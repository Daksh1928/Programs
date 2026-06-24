package DataStructure.Arrays;

import java.util.Scanner;

public class TwoDarray {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Enter target element : ");
        int target = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    System.out.print("Element found at index : [" + (i + 1) + " " + (j + 1) + "]");
                }
            }
        }
    }
}