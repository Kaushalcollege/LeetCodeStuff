class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        """
            -- The problem describes the number of triplets to be returned that can make a triangle.
            -- Example:
                -- nums = [2, 2, 3, 4]
                -- the number of triplets are 3.
                -- 2,3,4 (using the first 2)
                   2,3,4 (using the second 2)
                   2,2,3
                -- from this example, we can conclude that duplicates are supposed to be treated individually.

            -- But how exactly do we determine this? Like what forms a triangle?
            -- Key Formula is the triangle inequality rule:
                -- For any three sides a, b & c such that a <= b <= c, a valid triangle only exists if (a + b) > c.
            
            -- The key here is to first sort this array at first.
            -- Use the 3 - pointer technique.
            -- Fix k-pointer at the largest -- meaning at the very end.
            -- then i-pointer starts from 0 and j pointer starts from (k - 1)th index.
            -- check condition -- (arr[i] + arr[j]) > arr[k] and then increment i and decrement j till i < j only.
            -- and then decrement k till k >= 2, because then we only have 2 indices to check.

            -- Let's speed run it:

            -- In the two-pointer loop, you don’t want to increment i and decrement j at the same time.
               That skips potential pairs.

            -- Think about this: if (nums[i] + nums[j]) > nums[k], then all elements between i and j-1 with j are valid. 
            That’s where the bulk counting comes in.

            -- If the condition fails, instead of moving both pointers, you should only adjust one pointer (hint: which one would make the sum larger?).

            -- So the missing piece is how you manage the i and j movements — that’s where your current code diverges.
        """

        nums.sort()

        count = 0

        for k in range(len(nums) - 1, 1, -1):
            i, j = 0, k - 1

            while j > i:
                if ((nums[i] + nums[j]) > nums[k]):
                    count += j - i
                    j -= 1

                else: i += 1

        
        return count
        