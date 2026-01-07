# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.maxi = 0
        self.total = 0

    def maxProduct(self, root: Optional[TreeNode]) -> int:
        self.dfs_total(root)

        self.dfs_max(root)

        # return self.maxi
        return self.maxi % (10**9 + 7)

    def dfs_total(self, node) :
        if node == None : return

        self.total += node.val
        self.dfs_total(node.left)
        self.dfs_total(node.right)

    def dfs_max(self, node) :
        if node == None : return 0

        left, right = self.dfs_max(node.left), self.dfs_max(node.right)

        sub_tree = left + right + node.val

        prod = sub_tree * (self.total - sub_tree)
        if prod > self.maxi : self.maxi = prod

        return sub_tree