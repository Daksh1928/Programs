package LogicalThinking.EasyAndMedium;

class Solution2 {
    // Function to print Pattern 20
    public void pattern20(int n) {
        // Initialize spaces between star blocks
        int spaces = 2 * n - 2;

        // Loop for rows
        for (int i = 1; i <= 2 * n - 1; i++) {
            // Calculate stars for first half
            int stars = i;

            // Adjust stars for second half
            if (i > n)
                stars = 2 * n - i;

            // Print left stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            // Print spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Print right stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();

            // Adjust spaces for next row
            if (i < n)
                spaces -= 2;
            else
                spaces += 2;
        }
    }
}

public class Pattern20 {
    public static void main(String[] args) {
        // Create solution object
        Solution2 sol = new Solution2();
        // Define N
        int N = 5;
        // Call pattern function
        sol.pattern20(N);
    }
}
