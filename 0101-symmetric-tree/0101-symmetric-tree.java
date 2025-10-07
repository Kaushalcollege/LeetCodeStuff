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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // Empty tree is symmetric
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode n1, TreeNode n2) {
        // Both null → symmetric at this level
        if (n1 == null && n2 == null) return true;
        
        // One null → asymmetric
        if (n1 == null || n2 == null) return false;
        
        // Values differ → asymmetric
        if (n1.val != n2.val) return false;
        
        // Mirror recursion: left of n1 vs right of n2 AND right of n1 vs left of n2
        return helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }
}