class Solution:
    def nextBeautifulNumber(self, n: int) -> int:

        if (n < 0) : return 0
        while (True) :
            n += 1
            if (self.is_beautiful(n)) : return n

    def is_beautiful(self, x : int) -> bool :
        res = {}
        rem = 0

        while(x > 0) :
            rem = x % 10
            res[rem] = res.get(rem, 0) + 1
            x //= 10

        for a, b in res.items() :
            if a != b :
                return False

        return True
        