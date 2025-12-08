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

class Node {
    TreeNode node;
    int level;

    public Node (TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // int level = 1;
        q.offer(new Node(root, 0));
        while (!q.isEmpty()){
            Node curr = q.poll();
            while (res.size() <= curr.level) res.add(new ArrayList<>());
            res.get(curr.level).add(curr.node.val);
            if (curr.node.left != null) {
                q.offer(new Node(curr.node.left, curr.level + 1));
            }
            if (curr.node.right != null) {
                q.offer(new Node(curr.node.right, curr.level + 1));
            }
        }
        // for (List<TreeNode> arr : res){
        //     for (TreeNode i : arr) {
        //         if (i != null) System.out.println(i.val);
        //         else System.out.println("null");
        //     }
        // }
        return res;
    }
}