class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) return true;
        int charStart = -1;

        int idx = 0;
        while (idx < bits.length){
            if (bits[idx] == 0 && (charStart == -1 || charStart != -1)) {
                // this is one-bit character
                idx++;
                // continue;
            }
            else if (bits[idx] == 1 && (bits[idx + 1] == 0 || bits[idx + 1] == 1)){
                charStart = idx;
                idx += 2;
            }
            if (idx == bits.length - 1 && bits[idx] == 0) return true;
        }
        return false;
    }
}