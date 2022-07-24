T = int(input())

for tc in range(1, T+1):
    N = int(input())
    original_list = [input().split() for x in range(0, N)]
    
    rotate_90 = [[original_list[i][index] for i in range(N-1, 0-1, -1)] for index in range(0, N) ]
    rotate_180 = [[rotate_90[i][index] for i in range(N-1, 0-1, -1)] for index in range(0, N) ]
    rotate_270 = [[rotate_180[i][index] for i in range(N-1, 0-1, -1)] for index in range(0, N) ]

    print('#{}'.format(tc))
    for i in range(0, N):
        print('{} {} {}'.format(''.join(rotate_90[i]), ''.join(rotate_180[i]), ''.join(rotate_270[i])))
    
