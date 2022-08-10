import sys

N, K = tuple(map(int, sys.stdin.readline().strip().split()))
num_list = list(map(int, sys.stdin.readline().strip().split()))

num_list = sorted(num_list)
print(num_list[K-1])

