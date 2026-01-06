class Solution {
    public String frequencySort(String s) {
        // Count character frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Use a max heap (PriorityQueue) to sort characters by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        // Build the result string
        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            result.append(String.valueOf(ch).repeat(freqMap.get(ch)));
        }
        return result.toString();
    }
}