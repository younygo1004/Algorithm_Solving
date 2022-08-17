# pypy3로 돌릴 시, 메모리 초과. python3로 돌릴 것
import sys

N = int(sys.stdin.readline())

num_list = [0] * 10001

for _ in range(N):
    num_list[int(sys.stdin.readline())] += 1

for i in range(1, 10000+1):
    for j in range(num_list[i]):
        print(i)
