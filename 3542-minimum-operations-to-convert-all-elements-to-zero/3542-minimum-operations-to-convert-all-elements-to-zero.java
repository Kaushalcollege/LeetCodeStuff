import java.util.*;

class Node {
    int val;
    Node prev, next;
    Node(int v) {
        val = v;
    }
}

class Solution {
    public int minOperations(int[] nums) {
        Node head = new Node(-1);
        Node current = head;
        Map<Integer, List<Node>> lookup = new HashMap<>();

        for (int x : nums) {
            Node node = new Node(x);
            current.next = node;
            node.prev = current;
            lookup.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
            current = node;
        }

        int total = 0;
        List<Integer> keys = new ArrayList<>(lookup.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        for (int x : keys) {
            if (x == 0) continue;
            for (Node node : lookup.get(x)) {
                if (!(node.next != null && node.val == node.next.val)) {
                    total++;
                }
                if (node.next != null) node.next.prev = node.prev;
                if (node.prev != null) node.prev.next = node.next;
            }
        }
        return total;
    }
}
