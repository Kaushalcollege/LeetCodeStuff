class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> stk = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            if(!stk.isEmpty()){
                // stk.push(new int[]{temperatures[i], i});
                // if (stk.peek()[0] < temperatures[i]) {
                    while (!stk.isEmpty() && stk.peek()[0] < temperatures[i]) {
                        ans[stk.peek()[1]] = i - stk.peek()[1];
                        stk.pop();
                    }
                    stk.push(new int[]{temperatures[i], i});
                // }
                // else stk.push(new int[]{temperatures[i], i});
            }
            else{
                stk.push(new int[]{temperatures[i], i});
            }

            // System.out.println(stk);
        }

        return ans;
    }
}