import sys

N = int(sys.stdin.readline())

num_list = list(map(int, sys.stdin.readline().strip().split()))

index_dict = dict(enumerate(num_list))

sorted_dict = dict(sorted(index_dict.items(), key=lambda x : x[1]))

iter_cnt = 0
for key_origin, key_sorted in zip(index_dict.keys(), sorted_dict.keys()):
    iter_cnt += abs(key_sorted-key_origin)

print(iter_cnt)
