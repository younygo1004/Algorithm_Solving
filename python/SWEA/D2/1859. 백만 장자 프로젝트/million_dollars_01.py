T = int(input())

for tc in range(1, T+1):

    N = int(input())
    num_list = list(map(int, input().split()))

    sum_profit = 0

    idx = N-2
    point = N-1
    while 0 <= idx:
        profit = num_list[point] - num_list[idx]
        if profit > 0:
            sum_profit += profit
        else:
            point = idx
        idx -= 1
    
    print("#{} {}".format(tc, sum_profit))

