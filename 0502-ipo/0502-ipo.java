class Solution {
    public int findMaximizedCapital(int K, int W, int[] profits, int[] capitals) {
        int[][] projects = new int[profits.length][2];
    
    for (int i = 0; i < projects.length; i++) {
        projects[i][0] = capitals[i];
        projects[i][1] = profits[i];
    }
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    
    Arrays.sort(projects, new Comparator<int[]>() {
        public int compare (int[] a, int[] b) {return a[0] - b[0];}
    });
    
    int i = 0;
    
    // for (int[] project : projects) {
    //     int cap = project[0];
        
    //     minHeap.add(project[1]);
    //     W -= cap;
        
    //     if (minHeap.size()  K) W += minHeap.poll();
        
    //     ans = Math.max(ans, W);
    // }
    
    for (int j = 0; j < K; j++) {
        while (i < profits.length && projects[i][0] <= W) {
            maxHeap.add(projects[i][1]);
            i++;
        }
        
        if (maxHeap.isEmpty()) break;
        
        W += maxHeap.poll();
    }
    
    return W;
    }
}