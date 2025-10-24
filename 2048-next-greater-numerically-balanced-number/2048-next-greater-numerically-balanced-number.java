import java.util.*;

class Solution {
    public int nextBeautifulNumber(int n) {
        /*
            -- 1 digits -> 1
            -- 2 digits -> 22
            -- 3 digits -> 122, 333, 221, 212 -> 4 numbers
            -- 4 digits -> 1333, 4444 -> 5 numbers
            -- 5 digits -> 14444, 22333, 55555 -> 16 numbers
            -- 6 digits -> 155555, 224444, 122333, 666666 -> 82 numbers
            -- 7 digits -> 1224444 -> smallest number
            So total = 110 beautiful numbers
        */

        // Predefined base beautiful numbers (without permutation duplicates)
        int[] bases = {1, 22, 122, 333, 1333, 4444, 14444, 22333, 55555, 155555, 224444, 122333, 666666, 1224444};

        TreeSet<Integer> all = new TreeSet<>();
        for (int base : bases) {
            all.addAll(gen_permutations(base));
        }

        for (int num : all) {
            if (num > n) return num;
        }
        return -1;
    }

    private List<Integer> gen_permutations(int x) {
        List<Integer> result = new ArrayList<>();
        char[] digits = String.valueOf(x).toCharArray();
        Arrays.sort(digits); // ensure lexicographic order
        boolean[] used = new boolean[digits.length];
        backtrack(digits, new StringBuilder(), used, result);
        return result;
    }

    private void backtrack(char[] digits, StringBuilder path, boolean[] used, List<Integer> result) {
        if (path.length() == digits.length) {
            result.add(Integer.parseInt(path.toString()));
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1]) continue; // skip duplicates
            used[i] = true;
            path.append(digits[i]);
            backtrack(digits, path, used, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}
