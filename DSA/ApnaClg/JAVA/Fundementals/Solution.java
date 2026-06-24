import java.util.*;

public class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
            int[] waterStartTime, int[] waterDuration) {

        int ans1 = solve(landStartTime, landDuration,
                waterStartTime, waterDuration);

        int ans2 = solve(waterStartTime, waterDuration,
                landStartTime, landDuration);

        return Math.min(ans1, ans2);
    }

    private int solve(int[] firstStart, int[] firstDur,
            int[] secondStart, int[] secondDur) {

        int n = firstStart.length;

        // store [finishTime]
        int[] finish = new int[n];

        for (int i = 0; i < n; i++) {
            finish[i] = firstStart[i] + firstDur[i];
        }

        Arrays.sort(finish);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < secondStart.length; i++) {

            int start = secondStart[i];
            int dur = secondDur[i];

            // Binary search for largest finish <= second start
            int idx = upperBound(finish, start);

            // Case 1: can start immediately
            if (idx >= 0) {
                ans = Math.min(ans, start + dur);
            }

            // Case 2: wait for later ride
            if (idx + 1 < n) {
                ans = Math.min(ans, finish[idx + 1] + dur);
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}