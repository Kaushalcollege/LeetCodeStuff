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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int currSum = 0;
        return dfsSum(root, targetSum, currSum);
        // return currSum == targetSum;
    }

    public boolean dfsSum (TreeNode node, int t, int s){
        if (node == null) return false;
        s += node.val;
        if (node.left == null && node.right == null) return s == t;

        //traverse right subtree and left subtree:
        return dfsSum(node.left, t, s) || dfsSum(node.right, t, s);
    }
}