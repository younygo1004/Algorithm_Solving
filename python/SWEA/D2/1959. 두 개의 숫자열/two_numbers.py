T = int(input())

for tc in range(1, T+1):
    N, M = tuple(map(int, input().split()))
    a_list = list(map(int, input().split()))
    b_list = list(map(int, input().split()))

    iter_cnt = abs(len(a_list) - len(b_list))

    sum_list = []

    if len(a_list) < len(b_list):
        for i in range(0, iter_cnt+1):
            sum  = 0
            for j in range(0, N):
                sum += a_list[j] * b_list[i+j]
            sum_list.append(sum)
    else:
        for i in range(0, iter_cnt+1):
            sum  = 0
            for j in range(0, M):
                sum += a_list[i+j] * b_list[j]
            sum_list.append(sum)

    print('#{} {}'.format(tc, max(sum_list)))
