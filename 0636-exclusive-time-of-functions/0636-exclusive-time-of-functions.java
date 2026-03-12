import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        // Stack stores arrays of: {func_id, start_time, accumulated_time}
        Stack<int[]> st = new Stack<>();

        for(int i = 0 ; i < logs.size(); i++){
            String s = logs.get(i);
            String[] stuff = s.split(":");
            
            int func_id = Integer.parseInt(stuff[0]);
            String task = stuff[1];
            int time = Integer.parseInt(stuff[2]);

            if (task.equals("start") && !st.isEmpty()) {
                int[] curr = st.peek();
                // Add the time spent before pausing to accumulated time
                curr[2] += time - curr[1];
                
                // Push the new function onto the stack
                st.push(new int[]{func_id, time, 0});
            }
            else if (task.equals("start") && st.isEmpty()){
                // Push the very first function
                st.push(new int[]{func_id, time, 0});
            }
            else if (task.equals("end")) {
                int[] curr = st.pop();
                // Calculate total time: accumulated + current segment (needs +1 for end inclusive)
                curr[2] += time - curr[1] + 1;
                res[curr[0]] += curr[2];
                
                // If there's a function underneath that is now resuming, update its start time
                if (!st.isEmpty()) {
                    st.peek()[1] = time + 1;
                }
            }
        }

        return res;
    }
}