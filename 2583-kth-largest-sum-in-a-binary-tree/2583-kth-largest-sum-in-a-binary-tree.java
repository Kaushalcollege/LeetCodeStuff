/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // List<Integer> res = new ArrayList<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // int currLevel = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            long sum = 0;

            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();

                sum += node.val;

                // Enqueue left child
                if (node.left != null)
                    q.offer(node.left);

                // Enqueue right child
                if (node.right != null)
                    q.offer(node.right);
            }

            maxHeap.add(sum);
        }
        // System.out.println(maxHeap);

        // List<Integer> res = new ArrayList<>(maxHeap);
        // return res.get(k);

        if (k > maxHeap.size()) return -1;

        while (--k > 0) {
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
}