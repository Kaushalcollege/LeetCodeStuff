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
    private int currentval;
    private int currentcount = 0;
    private int maxcount = 0;
    List<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++) res[i] = modes.get(i);
        return res;
    }
    private void inOrderTraversal(TreeNode node){
        if (node == null) return;

        inOrderTraversal(node.left);

        currentcount = (node.val == currentval) ? currentcount + 1 : 1;
        if (currentcount == maxcount) modes.add(node.val);
        else if (currentcount > maxcount){
            maxcount = currentcount;
            modes.clear();
            modes.add(node.val);
        }
        currentval = node.val;

        inOrderTraversal(node.right);
    }
}