class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        ops = {
            "++X": 1,
            "X++": 1,
            "--X": -1,
            "X--": -1,
        }

        total = 0
        for op in operations:
            total += ops[op]

        return total
