class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int drank = numBottles;
        int empty = 0;
       while (numBottles > 0) {
        drank = numBottles;
        total += drank;
        empty += drank;
        numBottles = empty / numExchange;
        empty %= numExchange;
       }
    return total;
    }
}