class Solution {
    static final int MOD = 1000000007;
    public int countPermutations(int[] complexity) {
        int MOD = 1000000007;
        int[] computers = new int[complexity.length];
        for (int i = 0; i < computers.length; i++) computers[i] = i;
        boolean[] unlocked = new boolean[computers.length];

        unlocked[0] = true;

        // permutate(computers, unlocked);

        int min = complexity[0];
        int count = 0;
        for (int i : complexity) {
            if (i < min) min = i;
            if (i == min) count++;
        }

        if (complexity[0] != min) return 0;
        if (count > 1) return 0;
        // System.out.println(fact(complexity.length - 1));
        return fact(complexity.length);
    }

    private int fact(int n) {
        int ans = 1;
        for (int i = 2; i < n; i++) {
            ans = (int) (((long) ans * i) % MOD);
        }
        return ans;
    }

    /*
        -- any computer at ith-position within the computers array can be decrypted:
        -- if there is an computer at the index j, which has already been unlocked (unlocked[j] == true).
        -- j < i
        -- complexity[j] < complexity[i];
    */
    // we can use backtracking to cover this.
    // private void permutate(int[] comp, boolean[] unlocked) {

    // }

    // private boolean isValid(int j, int j, int[] comp, boolean[] unlocked){
    //     if (i > j && complexity[i] > complexity[j] && unlocked[j] == true) return true;
    //     return false;
    // }
}