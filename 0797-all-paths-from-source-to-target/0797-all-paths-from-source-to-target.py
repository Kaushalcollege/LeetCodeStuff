from typing import List

class Solution:
    class Edge:
        def __init__(self, src: int, dest: int):
            self.src = src
            self.dest = dest

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        g = self.creation(graph)

        res = []
        v = [False] * len(g)

        self.dfs(g, v, 0, [], res, len(g) - 1)
        return res

    def creation(self, graph: List[List[int]]) -> List[List["Solution.Edge"]]:
        g = [[] for _ in range(len(graph))]

        for i in range(len(graph)):
            for j in range(len(graph[i])):
                g[i].append(Solution.Edge(i, graph[i][j]))
        return g

    def dfs(self, g: List[List["Solution.Edge"]], v: List[bool], curr: int,
            path: List[int], res: List[List[int]], tar: int) -> None:
        path.append(curr)
        if curr == tar:
            res.append(path[:])   # add copy of current path
            path.pop()
            return

        for e in g[curr]:
            if not v[e.dest]:
                v[curr] = True
                self.dfs(g, v, e.dest, path, res, tar)
                v[curr] = False

        path.pop()
