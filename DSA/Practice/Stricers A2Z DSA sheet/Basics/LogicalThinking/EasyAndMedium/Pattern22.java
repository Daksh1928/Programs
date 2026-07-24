package LogicalThinking.EasyAndMedium;

class Solution4 {
    // Function to print concentric square number pattern
    public void pattern22(int n) {
        // Outer loop for rows
        for (int i = 0; i < 2 * n - 1; i++) {
            // Inner loop for columns
            for (int j = 0; j < 2 * n - 1; j++) {
                // Calculate distance from top
                int top = i;
                // Calculate distance from left
                int left = j;
                // Calculate distance from bottom
                int bottom = (2 * n - 2) - i;
                // Calculate distance from right
                int right = (2 * n - 2) - j;

                // Take the minimum of all four distances
                int minDist = Math.min(Math.min(top, bottom), Math.min(left, right));

                // Print number (starts with n at border, decreases inside)
                System.out.print((n - minDist) + " ");
            }
            // Move to the next row
            System.out.println();
        }
    }
}

public class Pattern22 {
    public static void main(String[] args) {
        // Create object of Solution class
        Solution4 sol = new Solution4();

        // Define size of pattern
        int N = 5;

        // Call pattern function
        sol.pattern22(N);
    }
}
