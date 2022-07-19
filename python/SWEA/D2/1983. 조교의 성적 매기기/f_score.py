import math

T = int(input())

score_dict = {
    1: 'A+',
    2: 'A0',
    3: 'A-',
    4: 'B+',
    5: 'B0',
    6: 'B-',
    7: 'C+',
    8: 'C0',
    9: 'C-',
    10: 'D0',
}

for tc in range(1, T+1):
    N, K = tuple(map(int, input().split()))
    score_list = [(lambda x : x[0]*0.35+x[1]*0.45+x[2]*0.2)(list(map(int, input().split()))) for i in range(0, N)]
    sorted_list = list(reversed(sorted(score_list)))
    ranking = sorted_list.index(score_list[K-1]) + 1
    print('#{} {}'.format(tc, score_dict[math.ceil(ranking / (N // 10))]))
    
