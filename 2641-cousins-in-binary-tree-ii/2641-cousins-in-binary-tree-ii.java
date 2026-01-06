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
    public TreeNode replaceValueInTree(TreeNode root) {
        TreeNode res = new TreeNode(0);
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            int sum = 0;

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

            arr.add(sum);
        }
        
        // res = dfs (root, res, arr, 0);
        // cousinsOnly (res, null, root, null);
        // return res;

        root.val = 0;
        dfs (root, arr, 1);
        return root;
    }
    // private TreeNode dfs (TreeNode orig, TreeNode copy, List<Integer> list, int depth) {
    //     if (orig == null) return null;
    //     copy.val = list.get(depth);
    //     copy.left = dfs (orig.left, new TreeNode(), list, depth + 1);
    //     copy.right = dfs (orig.right, new TreeNode(), list, depth + 1);
    //     return copy;
    // }

    // private void cousinsOnly (TreeNode root1, TreeNode parent1, TreeNode root2, TreeNode parent2) {
    //     if (root1 == null) return;
    //     if (parent1 != null && parent1.left == root1) root1.val -= (root2.val + parent2.right.val);
    //     else if (parent1 != null && parent1.right == root1) root1.val -= (root2.val + parent2.left.val);
    //     else root1.val -= root2.val;

    //     cousinsOnly (root1.left, root1, root2.left, root2);
    //     cousinsOnly (root1.right, root1, root2.right, root2);
    // }

    public void dfs (TreeNode node, List<Integer> arr, int depth) {
        if (node == null) return;

        int children = 0;
        if (node.left != null) children += node.left.val;
        if (node.right != null) children += node.right.val;

        if (node.left != null) node.left.val = arr.get(depth) - children;
        if (node.right != null) node.right.val = arr.get(depth) - children;

        dfs (node.left, arr, depth + 1);
        dfs (node.right, arr, depth + 1);
    }
}