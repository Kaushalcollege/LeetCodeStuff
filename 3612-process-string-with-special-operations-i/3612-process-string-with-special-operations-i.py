class Solution:
    def processStr(self, s: str) -> str:
        res = ""

        for c in s :
            if c.isalpha() : res += c
            elif c == '#' : res += res
            elif c == '*' and len(res) > 0 : res = res[:-1]
            else : res = res[::-1]

        return res