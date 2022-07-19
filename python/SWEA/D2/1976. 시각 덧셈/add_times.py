T = int(input())

for tc in range(1, T+1):
    time_list = list(map(int, input().split()))
    add_time, minute = divmod(time_list[1] + time_list[3], 60)
    time = 12 if (time_list[0] + time_list[2] + add_time) % 12 == 0 else (time_list[0] + time_list[2] + add_time) % 12

    print('#{} {} {}'.format(tc, time, minute))