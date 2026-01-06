# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        res = [-math.inf, 0]  

        # q = []
        q = deque([root])
        curr_level = 0
        q.append(root)

        while q :
            q_size = len(q)
            total = 0
            curr_level += 1

            # for i in q : total += i.val

            # if (res[0] < total) : 
            #     res[0] = total
            #     res[1] = curr_level

            for i in range (q_size) :

                node = q.popleft()
                total += node.val
                if node.left != None : q.append(node.left)
                if node.right != None : q.append(node.right)

            if (res[0] < total) : 
                res[0] = total
                res[1] = curr_level

        
        return res[1]