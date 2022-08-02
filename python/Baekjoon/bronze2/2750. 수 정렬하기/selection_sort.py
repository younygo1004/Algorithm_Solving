import sys

N = int(sys.stdin.readline())

num_list = [int(sys.stdin.readline()) for i in range(0, N)]

for i in range(0, N):
    min_idx = i
    for j in range(i, N):
        if num_list[min_idx] > num_list[j]:
            min_idx = j

    num_list[i], num_list[min_idx] = num_list[min_idx], num_list[i]

for i in num_list:
    print(i)