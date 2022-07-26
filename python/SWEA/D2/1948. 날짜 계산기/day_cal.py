T = int(input())

days_list = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

for tc in range(1, T+1):
    first_month, first_day, second_month, second_day = tuple(map(int, input().split()))
    print('#{} {}'.format(tc, sum(days_list[first_month:second_month])-first_day+second_day+1))