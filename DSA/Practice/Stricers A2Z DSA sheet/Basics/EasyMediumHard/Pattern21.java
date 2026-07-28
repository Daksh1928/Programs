package LogicalThinking.EasyAndMedium;

class Solution3 {
    // Function to print hollow square pattern
    public void pattern21(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Inner loop for columns
            for (int j = 0; j < n; j++) {
                // Print star if it's a border cell
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
                    System.out.print("*");
                // Print space otherwise
                else
                    System.out.print(" ");
            }
            // Move to next line after each row
            System.out.println();
        }
    }
}

public class Pattern21 {
    public static void main(String[] args) {
        // Create solution object
        Solution3 sol = new Solution3();
        // Define N
        int N = 5;
        // Call pattern function
        sol.pattern21(N);
    }
}
