import sys

N = int(sys.stdin.readline())

num_list = [int(sys.stdin.readline()) for i in range(N)]

index_dict = dict(enumerate(num_list))

sorted_dict = dict(sorted(index_dict.items(), key=lambda x : x[1]))

iter_cnt = 0
for key_origin, key_sorted in zip(index_dict.keys(), sorted_dict.keys()):
    iter_cnt = max(iter_cnt, key_sorted-key_origin)

print(iter_cnt+1)
