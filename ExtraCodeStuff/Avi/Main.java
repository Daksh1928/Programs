class Solution {
    private static final int UNSET = 10;

    private char[] digits;
    private long[][][][][] memoCount;
    private long[][][][][] memoSum;
    private boolean[][][][][] seen;

    public long totalWaviness(long num1, long num2) {
        return countUpTo(num2) - countUpTo(num1 - 1);
    }

    private long countUpTo(long n) {
        if (n < 0) return 0L;

        digits = Long.toString(n).toCharArray();
        int len = digits.length;

        memoCount = new long[len + 1][11][11][2][2];
        memoSum = new long[len + 1][11][11][2][2];
        seen = new boolean[len + 1][11][11][2][2];

        long[] ans = dfs(0, UNSET, UNSET, 1, 0);
        return ans[1]; // total waviness
    }

    // returns [countOfNumbers, totalWaviness]
    private long[] dfs(int pos, int prev2, int prev1, int tight, int started) {
        if (pos == digits.length) {
            return new long[] {1L, 0L};
        }

        if (seen[pos][prev2][prev1][tight][started]) {
            return new long[] {
                memoCount[pos][prev2][prev1][tight][started],
                memoSum[pos][prev2][prev1][tight][started]
            };
        }

        long totalCount = 0L;
        long totalSum = 0L;

        int limit = (tight == 1) ? (digits[pos] - '0') : 9;

        for (int d = 0; d <= limit; d++) {
            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            int nextStarted = (started == 1 || d != 0) ? 1 : 0;

            int nPrev2, nPrev1;
            long add = 0L;

            if (nextStarted == 0) {
                nPrev2 = UNSET;
                nPrev1 = UNSET;
            } else if (started == 0) {
                // first non-zero digit
                nPrev2 = UNSET;
                nPrev1 = d;
            } else {
                // We now have at least 2 previous significant digits.
                // prev1 is the middle digit of the last 3-digit window.
                if (prev2 != UNSET) {
                    if ((prev2 < prev1 && prev1 > d) || (prev2 > prev1 && prev1 < d)) {
                        add = 1L;
                    }
                }
                nPrev2 = prev1;
                nPrev1 = d;
            }

            long[] child = dfs(pos + 1, nPrev2, nPrev1, nextTight, nextStarted);

            totalCount += child[0];
            totalSum += child[1] + child[0] * add;
        }

        seen[pos][prev2][prev1][tight][started] = true;
        memoCount[pos][prev2][prev1][tight][started] = totalCount;
        memoSum[pos][prev2][prev1][tight][started] = totalSum;

        return new long[] {totalCount, totalSum};
    }
}

// Local test harness
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        runTest(sol, 120, 130, 3L);
        runTest(sol, 198, 202, 3L);
        runTest(sol, 4848, 4848, 2L);
        runTest(sol, 1, 9, 0L);
        runTest(sol, 1, 100, 0L);
        runTest(sol, 100, 999, 525L);
        runTest(sol, 1000, 1010, 2L);
        runTest(sol, 123, 321, 118L);
        runTest(sol, 100, 1000, 525L);
    }

    private static void runTest(Solution sol, long num1, long num2, long expected) {
        long actual = sol.totalWaviness(num1, num2);
        System.out.println("[" + num1 + ", " + num2 + "] -> " + actual
                + " | expected: " + expected
                + " | " + (actual == expected ? "PASS" : "FAIL"));
    }
}