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
    public boolean isCompleteTree(TreeNode root) {
        //We can traverse in order and add;
        List<TreeNode> res = new ArrayList<>();
        traverse(root, res);
        for (TreeNode i : res) {
            if (i != null) System.out.println(i.val);
            else System.out.println("null");
        }
        boolean nullSeen = false;

        for (TreeNode node : res) {
            if (node == null) nullSeen = true;
            else if (nullSeen) return false; // non-null after null
        }

        return true;
    }

    private void traverse(TreeNode node, List<TreeNode> nodeStore){
        Queue<TreeNode> q = new LinkedList<>();
        if (node != null){
            q.offer(node);
            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                nodeStore.add(curr);
                if (curr != null){
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
        }
    }
}