import sys

# N = 정점의 개수, M은 간선의 개수
N, M = map(int, sys.stdin.readline().strip().split())
graph = dict(enumerate([[] for _ in range(N)], 1))

for _ in range(M):
    start, dest = map(int, sys.stdin.readline().strip().split())
    graph[start].append(dest)
