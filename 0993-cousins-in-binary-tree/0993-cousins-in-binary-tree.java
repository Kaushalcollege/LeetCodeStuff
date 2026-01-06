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
    public boolean isCousins(TreeNode root, int x, int y) {
        // TreeNode[] res = new TreeNode[2];
        int[] r = new int[4];
        dfs (root, r, null, x, y, 0);
        return (r[0] != r[1]) && (r[2] == r[3]);
    }

    private void dfs (TreeNode node, int[] r, TreeNode parent, int x, int y, int depth) {
        if (node == null) return;

        if (node.val == x) {
            if (parent != null) r[0] = parent.val;
            else r[0] = -1;
            r[2] = depth;
        }

        else if (node.val == y) {
            if (parent != null) r[1] = parent.val;
            else r[1] = -1;
            r[3] = depth;
        }

        dfs(node.left, r, node, x, y, depth + 1);
        dfs(node.right, r, node, x, y, depth + 1);
    }
}