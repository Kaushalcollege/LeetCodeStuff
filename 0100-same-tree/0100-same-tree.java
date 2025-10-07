// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (~(p == null ^ q == null)) return false;
//         if (p.val == q.val) return true;
//         else if (p.val != q.val) return false;

//         return isSameTree(p.left, q.left) || isSameTree(p.right, q.right);
//     }
// }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both null → trees match
        if (p == null && q == null) return true;
        
        // One null → trees differ
        if (p == null || q == null) return false;
        
        // Values differ → trees differ
        if (p.val != q.val) return false;
        
        // Recurse on left and right → both must match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}