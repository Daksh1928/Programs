package LogicalThinking.EasyAndMedium;

import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the number of rows under 26 : ");
        int n = sc.nextInt();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");          
            }
            for(int j=0;j<=2*i+1;j++){
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
        sc.close();
     }
}