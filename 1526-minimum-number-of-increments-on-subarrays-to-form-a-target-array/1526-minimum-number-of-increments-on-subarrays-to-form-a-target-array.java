class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        Map<Integer, Node> lookup = new HashMap<>();

        Node head = new Node(0);
        Node curr = head;

        List<int[]> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(target[i]);
            newNode.prev = curr;
            newNode.next = null;

            lookup.put(i, newNode);
            curr.next = newNode;
            curr = curr.next;

            s.add(new int[]{target[i], i});
        }

        curr.next = new Node(0); // tail sentinel

        // sort in reverse order by value
        s.sort((a, b) -> Integer.compare(b[0], a[0]));

        int total = 0;

        for (int[] pair : s) {
            int x = pair[0];
            int index = pair[1];
            Node node = lookup.get(index);

            // Skip if node already removed (might happen in linked removal)
            if (node.prev == null || node.next == null) continue;

            int delta;
            if (node.prev.val > node.next.val) {
                delta = node.val - node.prev.val;
                total += delta;
            } else {
                delta = node.val - node.next.val;
                total += delta;
            }

            Node nodeNext = node.next;
            Node nodePrev = node.prev;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
        }

        return total;
    }
}
