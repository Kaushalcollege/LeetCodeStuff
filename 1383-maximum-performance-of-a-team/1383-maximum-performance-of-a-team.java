class Solution {
    static int MOD = 1000000007;
    public int maxPerformance(int N, int[] speed, int[] efficiency, int K) {
        double[] ratio = new double[N];
    
    // for (int i = 0; i < N; i++) ratio[i] = (speed[i] % efficiency[i]);
    // System.out.println(Arrays.toString(ratio));
    // return 0;
    int[][] robos = new int[N][2];
    
    for (int i = 0; i < N; i++) {
        robos[i][0] = speed[i];
        robos[i][1] = efficiency[i];
    }
    
    Arrays.sort(robos, new Comparator<int[]>() {
        public int compare (int[] a, int[] b) {return b[1] - a[1];}
    });
    
    // for (int[] row : robos) System.out.println(Arrays.toString(row));
    
    // int sum = 0;
    // int min = Integer.MAX_VALUE;
    
    // for (int i = 0; i < K; i++) {
    //     min = Math.min(min, robos[i][1]);
    //     sum += robos[i][0];
    // }
    // return sum * min;
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    long speedSum = 0;
    long ans = 0;
    
    for (int[] robo : robos) {
        int currSpeed = robo[0];
        int currEfficieny = robo[1];
        
        minHeap.add(currSpeed);
        speedSum += currSpeed;
        
        if (minHeap.size() > K) speedSum -= minHeap.poll();
        
        ans = Math.max(ans, speedSum * currEfficieny);
        
    }
    
        return (int)(ans % MOD);
    }
}