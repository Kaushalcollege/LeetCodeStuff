class ATM {
    private long[] bank;
    private final int[] values = {20, 50, 100, 200, 500};

    public ATM() {
        bank = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) bank[i] += banknotesCount[i];
    }

    public int[] withdraw(long amount) {
        int[] used = new int[5];
        long remain = amount;

        // Try to use the largest notes first
        for (int i = 4; i >= 0; i--) {
            long canUse = Math.min(bank[i], remain / values[i]);
            used[i] = (int) canUse;
            remain -= canUse * values[i];
        }

        // If not possible, rollback
        if (remain != 0) return new int[]{-1};

        // Otherwise, deduct from bank
        for (int i = 0; i < 5; i++) bank[i] -= used[i];
        return used;
    }
}
