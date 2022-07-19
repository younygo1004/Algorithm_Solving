T = int(input())

for tc in range(1, T+1):
    N, M = tuple(map(int, input().split()))
    fly_list = []

    for i in range(0, N):
        fly_list.append(list(map(int, input().split())))
    max = -1

    for i in range(0, N-M+1):
        for j in range(0, N-M+1):
            died_fly_num = 0
            attack_fly_list = fly_list[i:i+M]

            for item in attack_fly_list:
                died_fly_num += sum(item[j:j+M])
            if died_fly_num > max:
                max = died_fly_num
    
    print('#{} {}'.format(tc, max))

