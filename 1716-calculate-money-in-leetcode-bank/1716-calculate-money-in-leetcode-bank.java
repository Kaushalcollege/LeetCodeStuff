class Solution {
    public int totalMoney(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++){
            if (i % 7 == 0) sum += 7 + (i / 7 - 1);
            else sum += (i % 7) + (i / 7);
        }
        return sum;
    }
}