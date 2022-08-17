# 메모리 초과 문제 발생!!
from collections import deque
import sys

N = int(sys.stdin.readline())
num_list = deque()

for i in range(N):
    num_list.append(int(sys.stdin.readline()))

buckets = [deque() for _ in range(10)]

div_nums = [pow(10, x) for x in range(0, 4+1)]

for item in div_nums:

    while num_list:
        num = num_list.popleft()
        buckets[(num // item) % 10].append(num)
    for q in buckets:
        while q:
            num_list.append(q.popleft())


for item in num_list:
    print(item)

