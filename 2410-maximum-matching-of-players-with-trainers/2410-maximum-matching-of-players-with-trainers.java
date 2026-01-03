class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, max = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                max++;
                i++;
                j++;
            }
            else j++;
        }
        return max;
    }
}