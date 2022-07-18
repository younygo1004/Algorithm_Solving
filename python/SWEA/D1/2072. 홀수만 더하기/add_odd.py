T = int(input())

for t in range(1, T+1):
    num_list = list(map(int, input().split()))

    sum_odds = 0
    for num in num_list:
        if num % 2 == 1:
            sum_odds += num
            
    print("#{} {}".format(t, sum_odds))
