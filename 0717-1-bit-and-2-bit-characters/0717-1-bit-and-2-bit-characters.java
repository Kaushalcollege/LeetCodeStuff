// class Solution {
//     public boolean isOneBitCharacter(int[] bits) {
//         if (bits.length == 1) return true;
//         int charStart = -1;

//         int idx = 0;
//         while (idx < bits.length){
//             if (bits[idx] == 0) {
//                 // this is one-bit character
//                 idx++;
//                 // continue;
//             }
//             else if (bits[idx] == 1 && (bits[idx + 1] == 0 || bits[idx + 1] == 1)){
//                 charStart = idx;
//                 idx += 2;
//             }
//             if (idx == bits.length - 1 && bits[idx] == 0) return true;
//         }
//         return false;
//     }
// }


class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        while (i < n - 1) { // stop before last bit
            if (bits[i] == 1) i += 2; // two-bit character
            else i += 1;              // one-bit character
        }

        return i == n - 1; // true only if last bit stands alone
    }
}

