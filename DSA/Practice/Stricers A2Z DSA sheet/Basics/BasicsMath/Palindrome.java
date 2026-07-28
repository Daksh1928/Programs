
import java.util.Scanner;

public class Palindrome {

    static boolean checkPalindrome(int n) {
        int temp = n;
        int rev = 0;
        int lastDigit = 0;

        while (n > 0) {
            lastDigit = n % 10;
            rev = rev * 10 + lastDigit;
            n /= 10;
        }
        if (temp == rev) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("Enter number : ");
        int n = sc.nextInt();

        boolean check = checkPalindrome(n);
        if (check) {
            System.out.println("Entered number is a Palindrome number");
        } else {
            System.out.println("Entered number is not a palindrome number try again!");
        }
    }
}
