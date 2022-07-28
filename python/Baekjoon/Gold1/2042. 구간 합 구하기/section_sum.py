import math
import sys

N, M, K = tuple(map(int, sys.stdin.readline().split()))

num_list = [int(sys.stdin.readline()) for i in range(0, N)]
# seg_tree = [0 for i in range(0, int(math.pow(math.ceil(math.sqrt(N)), 2) * 2))]
seg_tree = [0] * 3000000

def init_tree(start, end, index):

    if start == end:
        seg_tree[index] = num_list[start] # 잎 노드에 값 대입
        return seg_tree[index] # 잎 노드의 값 리턴
    mid = (start + end) // 2
    
    seg_tree[index] = init_tree(start, mid, index*2) + init_tree(mid+1, end, index*2+1)
    return seg_tree[index]

def modify_tree(start, end, change_idx, change_num, index):

    # 범위 왼쪽, 오른쪽은 검사하지 않는다.
    if end < change_idx or change_idx < start:
        return 0
    
    if start == end:
        if change_idx == start:
            tmp = change_num - seg_tree[index]
            seg_tree[index] = change_num
            return tmp
    
    mid = (start + end) // 2
    tmp = modify_tree(start, mid, change_idx, change_num, index*2) + modify_tree(mid+1, end, change_idx, change_num, index*2+1)
    seg_tree[index] += tmp
    return tmp

    

def get_sum(start, end, first_idx, second_idx, index):
    # 범위 왼쪽, 오른쪽은 검사하지 않는다.
    if end < first_idx or second_idx < start:
        return 0
    
    if first_idx <= start and end <= second_idx:
        return seg_tree[index]
    
    if start == end:
        return 0
    
    mid = (start + end) // 2
    return get_sum(start, mid, first_idx, second_idx, index*2) + get_sum(mid+1, end, first_idx, second_idx, index*2+1)

    
init_tree(0, N-1, 1)

for i in range(0, M+K):
    a, b, c = tuple(map(int, sys.stdin.readline().split()))
    if a == 1:
        modify_tree(0, N-1, b-1, c, 1)
    elif a == 2:
        print(get_sum(0, N-1, b-1, c-1, 1))
