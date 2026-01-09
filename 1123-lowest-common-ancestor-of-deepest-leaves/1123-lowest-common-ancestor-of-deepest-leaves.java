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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private NewNode dfs (TreeNode node) {

        if (node == null) return new NewNode (null, 0);

        NewNode left = dfs (node.left);
        NewNode right = dfs (node.right);

        if (left.depth > right.depth) return new NewNode (left.node, left.depth + 1);
        else if (left.depth < right.depth) return new NewNode (right.node, right.depth + 1);
        // else return new NewNode (node, depth + 1);

        return new NewNode (node, left.depth + 1);
    }
}

class NewNode {
    TreeNode node;
    int depth;

    public NewNode (TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}