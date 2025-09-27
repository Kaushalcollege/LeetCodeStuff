class Solution:
    def majorityFrequencyGroup(self, s: str) -> str:
        """
            -- What is this problem about?
            -- We are given a string s, where certain characters are repeated for certain number of times.
            -- What is frequency group?
            -- The frequency group for a value 'k' is the set of characters that appear exactly 'k' times in s.
            -- let us assume s = "aabbccc"
                    -- k == 2, group = {a, b}, n(group) = 2.
                    -- k == 1, group = {c}, n(group) = 1.

            -- My approach will be pretty basic -- initialize a frequency map
            -- and since the max length of s is 100, We can use List array.
        """
        from collections import Counter, defaultdict

        # Step 1: Frequency map of characters
        freq = Counter(s)

        # Step 2: Build frequency group table
        table = defaultdict(list)
        for ch, f in freq.items():
            table[f].append(ch)

        # Step 3: Find the best group
        best_size = 0
        best_freq = 0
        best_group = []

        for freq_val, chars in table.items():
            size = len(chars)
            if size > best_size or (size == best_size and freq_val > best_freq):
                best_size = size
                best_freq = freq_val
                best_group = chars

        # Step 4: Build result string
        return "".join(best_group)