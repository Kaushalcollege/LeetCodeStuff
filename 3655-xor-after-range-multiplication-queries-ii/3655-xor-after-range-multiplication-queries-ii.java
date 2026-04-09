class Solution {
    static final int MOD = 1_000_000_007;

    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int blockSize = Math.max(1, (int) Math.sqrt(n));

        // Group queries by step size (k)
        List<List<int[]>> queriesByStep = new ArrayList<>();
        for (int i = 0; i <= blockSize; i++) {
            queriesByStep.add(new ArrayList<>());
        }

        // Separate large-step and small-step queries
        for (int[] query : queries) {
            int left = query[0], right = query[1], step = query[2], multiplier = query[3];
            if (step > blockSize) {
                // Directly process large-step queries
                for (int idx = left; idx <= right; idx += step) {
                    nums[idx] = (int) ((1L * nums[idx] * multiplier) % MOD);
                }
            } else {
                queriesByStep.get(step).add(new int[]{left, right, step, multiplier});
            }
        }

        // Process small-step queries using difference array technique
        for (int step = 1; step <= blockSize; step++) {
            if (queriesByStep.get(step).isEmpty()) continue;

            // Bucket queries by remainder (index % step)
            Map<Integer, List<int[]>> remainderBuckets = new HashMap<>();
            for (int[] query : queriesByStep.get(step)) {
                int left = query[0], right = query[1], multiplier = query[3];
                int remainder = left % step;
                int startIndex = (left - remainder) / step;
                int endIndex = (right - remainder) / step;
                remainderBuckets.computeIfAbsent(remainder, x -> new ArrayList<>())
                                .add(new int[]{startIndex, endIndex, multiplier});
            }

            for (Map.Entry<Integer, List<int[]>> entry : remainderBuckets.entrySet()) {
                int remainder = entry.getKey();
                List<int[]> updates = entry.getValue();

                int sequenceLength = (n - 1 - remainder >= 0) ? ((n - 1 - remainder) / step + 1) : 0;
                if (sequenceLength <= 0) continue;

                long[] diffArray = new long[sequenceLength + 1];
                Arrays.fill(diffArray, 1);

                for (int[] update : updates) {
                    int startIndex = update[0], endIndex = update[1], multiplier = update[2];
                    long inverseMultiplier = modPow(multiplier, MOD - 2); // modular inverse
                    diffArray[startIndex] = (diffArray[startIndex] * multiplier) % MOD;
                    if (endIndex + 1 <= sequenceLength) {
                        diffArray[endIndex + 1] = (diffArray[endIndex + 1] * inverseMultiplier) % MOD;
                    }
                }

                long cumulativeProduct = 1;
                for (int offset = 0; offset < sequenceLength; offset++) {
                    cumulativeProduct = (cumulativeProduct * diffArray[offset]) % MOD;
                    int actualIndex = remainder + offset * step;
                    nums[actualIndex] = (int) ((1L * nums[actualIndex] * cumulativeProduct) % MOD);
                }
            }
        }

        // Final XOR of all elements
        int xorResult = 0;
        for (int value : nums) {
            xorResult ^= value;
        }
        return xorResult;
    }
}

/*

Input
nums = [2,3,1,5,4]
queries = [[1,4,2,3], [0,2,1,2]]
n=5 → blockSize = 2

Query A: [l=1, r=4, k=2, v=3] → small step (k=2)

Query B: [l=0, r=2, k=1, v=2] → small step (k=1)

We can process small steps grouped by k (order doesn’t matter since multiplication mod MOD commutes).

Process k = 2

Lanes (k=2):

r=0: indices 0,2,4  (t = 0,1,2)
r=1: indices 1,3    (t = 0,1)


Query A: l=1 → remainder=1, so it targets lane r=1
tStart = (1-1)/2 = 0, tEnd = (4-1)/2 = 1

Lane r=1 → sequenceLength = ((4-1)/2 + 1) = 2 → t ∈ {0,1}

diff: size 3, init [1, 1, 1]
mark: diff[0] *= 3, diff[2] *= inv(3) → [3, 1, inv(3)]
prefix products over t=0..1:
  t=0: mult=3  → idx=1 → nums[1] = 3 * 3 = 9
  t=1: mult=3  → idx=3 → nums[3] = 5 * 3 = 15


Array now: [2, 9, 1, 15, 4]

Process k = 1

Single lane r=0 with all indices: 0,1,2,3,4 (t=0..4)
Query B: l=0, r=2 → tStart=0, tEnd=2

diff: size 6, init [1,1,1,1,1,1]
mark: diff[0]*=2, diff[3]*=inv(2) → [2,1,1,inv(2),1,1]
prefix products over t=0..4:
  t=0: mult=2 → idx=0 → 2*2 = 4
  t=1: mult=2 → idx=1 → 9*2 = 18
  t=2: mult=2 → idx=2 → 1*2 = 2
  t=3: mult stays 1 after cancel → idx=3 → 15*1 = 15
  t=4: mult=1 → idx=4 → 4*1 = 4


Final nums = [4, 18, 2, 15, 4]
XOR = 4 ^ 18 ^ 2 ^ 15 ^ 4 = 31
*/