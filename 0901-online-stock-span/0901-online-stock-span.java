class StockSpanner {
    // int[] == { price, span }
    Stack<int[]> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        if (stk.isEmpty()) {
            stk.push(new int[]{price, count});
            return count;
        }
        else {
            // int count = 1;
            while (!stk.isEmpty() && stk.peek()[0] <= price) {
                count += stk.peek()[1];
                stk.pop();
            }
            stk.push(new int[]{price, count});
            return count;
        }
        // return null;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */