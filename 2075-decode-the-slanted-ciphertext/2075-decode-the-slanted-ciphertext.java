class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cols - rows + 2; i++) {
            for(int j = i; j < n; j += cols + 1) sb.append(encodedText.charAt(j));
        }
        return sb.toString().stripTrailing();
    }
}