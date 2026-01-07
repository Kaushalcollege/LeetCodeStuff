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
    int MOD = 1000000007;
    long total = 0;
    long max = 0;
    public int maxProduct(TreeNode root) {

        // Logic for the problem ::
        dfsTotal (root);
        dfsMax (root);
        // System.out.println(total);

        return (int)(max % MOD);
    }

    private long dfsTotal (TreeNode node) {
        if (node == null) return 0;
        total += node.val;

        return total + dfsTotal(node.left) + dfsTotal(node.right);
    }

    private long dfsMax (TreeNode node) {
        if (node == null) return 0;

        // long left = dfsMax(node.left);
        // long right = dfsMax(node.right);
        long subTree = dfsMax(node.left) + dfsMax(node.right) + node.val;

        long prod = subTree * (total - subTree);
        max = Math.max(max, prod);

        return subTree;
    }
}