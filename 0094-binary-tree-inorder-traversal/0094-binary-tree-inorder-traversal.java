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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverseInOrder(root, res);
        return res;
    }

    private void traverseInOrder(TreeNode node, List<Integer> nodeStore){
        if (node != null) {traverseInOrder(node.left, nodeStore); nodeStore.add(node.val); traverseInOrder(node.right, nodeStore);}
    }
}