import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        Map<Integer, List<Integer>> primeFactorToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) continue;
            while (num > 1) {
                int p = spf[num];
                primeFactorToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (num % p == 0) {
                    num /= p;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        boolean[] visitedPrimes = new boolean[maxVal + 1];

        queue.add(0);
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int currIdx = queue.poll();

            if (currIdx == n - 1) {
                return dist[currIdx];
            }

            if (currIdx + 1 < n && dist[currIdx + 1] == -1) {
                queue.add(currIdx + 1);
                dist[currIdx + 1] = dist[currIdx] + 1;
            }
            if (currIdx - 1 >= 0 && dist[currIdx - 1] == -1) {
                queue.add(currIdx - 1);
                dist[currIdx - 1] = dist[currIdx] + 1;
            }

            int val = nums[currIdx];
            if (val > 1 && spf[val] == val) {
                int p = val;
                if (!visitedPrimes[p]) {
                    visitedPrimes[p] = true;
                    if (primeFactorToIndices.containsKey(p)) {
                        for (int destIdx : primeFactorToIndices.get(p)) {
                            if (dist[destIdx] == -1) {
                                queue.add(destIdx);
                                dist[destIdx] = dist[currIdx] + 1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}