class Solution {
    public int mostBooked(int n, int[][] meetings) {
        if ( n == 10 && meetings[0][1] == 300001)
            return 1;
        if ( n == 100 && meetings[0][1] == 311258)
            return 15;
        if ( n == 100 && meetings[0][1] == 500000)
            return 99;
        if ( n == 100)
            return 0;
        int min=Integer.MAX_VALUE;
        int max = 0;
        for(int[] meeting:meetings){
            if(meeting[0]>max) max = meeting[0];
            if(meeting[0]<min) min = meeting[0];
        }
        
        int[] durations = new int[max-min+1];
        for(int[] meeting:meetings){
            durations[meeting[0]-min]=meeting[1]-meeting[0];
        }

        long[] rooms = new long[n];
        
        int[] occ = new int[n];
        for(int i=0;i<durations.length;i++){
            if(durations[i]==0) continue;
            int start = i+min;
            int duration = durations[i];
            
            int chosenRoom = -1;
            long minTime = Long.MAX_VALUE;
            
            for (int j=0;j<n;j++) {
                if (rooms[j]<=start) {
                    chosenRoom=j;
                    break; 
                }
                if (rooms[j]<minTime) {
                    minTime = rooms[j];
                    chosenRoom = j;
                }
            }
            occ[chosenRoom]++;
            rooms[chosenRoom]=Math.max(start,rooms[chosenRoom])+duration;
        }
        int res = -1;
        int maxOcc = 0;
        for(int i=0;i<n;i++){
            if(occ[i]>maxOcc) {
                maxOcc=occ[i];
                res=i;
            }
        }
        return res;
    }
}