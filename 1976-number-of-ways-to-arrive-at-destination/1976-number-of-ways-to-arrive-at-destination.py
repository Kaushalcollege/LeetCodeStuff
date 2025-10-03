from typing import List
import heapq

class Solution:
    class Edge:
        def __init__(self, src: int, dest: int, time: int):
            self.src = src
            self.dest = dest
            self.time = time

    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        graph = self.creation(n, roads)
        dist = [float('inf')] * n
        dist[0] = 0
        ways = [0] * n
        ways[0] = 1
        MOD = 10**9 + 7

        pq = [(0, 0)]  # (currentTime, node)
        while pq:
            time, node = heapq.heappop(pq)
            if time > dist[node]:
                continue
            for e in graph[node]:
                newTime = time + e.time
                if newTime < dist[e.dest]:
                    dist[e.dest] = newTime
                    ways[e.dest] = ways[node]
                    heapq.heappush(pq, (newTime, e.dest))
                elif newTime == dist[e.dest]:
                    ways[e.dest] = (ways[e.dest] + ways[node]) % MOD

        return ways[n - 1] % MOD

    def creation(self, n: int, roads: List[List[int]]) -> List[List['Solution.Edge']]:
        graph = [[] for _ in range(n)]
        for u, v, t in roads:
            graph[u].append(Solution.Edge(u, v, t))
            graph[v].append(Solution.Edge(v, u, t))  # bidirectional
        return graph
