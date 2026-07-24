package LogicalThinking.EasyAndMedium;

class Solution {
    // Function to print Pattern 19
    public void pattern19(int N) {
        // Initial spaces for upper half
        int iniS = 0;

        // Loop for upper half rows
        for (int i = 0; i < N; i++) {
            // Print stars on left
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            // Print spaces in middle
            for (int j = 0; j < iniS; j++) {
                System.out.print(" ");
            }
            // Print stars on right
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            // Increase middle spaces by 2
            iniS += 2;
            // Move to next row
            System.out.println();
        }

        // Initial spaces for lower half
        iniS = 2 * N - 2;

        // Loop for lower half rows
        for (int i = 1; i <= N; i++) {
            // Print stars on left
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Print spaces in middle
            for (int j = 0; j < iniS; j++) {
                System.out.print(" ");
            }
            // Print stars on right
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Decrease middle spaces by 2
            iniS -= 2;
            // Move to next row
            System.out.println();
        }
    }
}

public class Pattern19 {
    public static void main(String[] args) {
        // Create solution object
        Solution sol = new Solution();
        // Define N
        int N = 5;
        // Call pattern function
        sol.pattern19(N);
    }
}
