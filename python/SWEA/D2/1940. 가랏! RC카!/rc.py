T = int(input())

for tc in range(1, T+1):
    N = int(input())
    
    sum = 0
    rc_speed = 0
    for i in range(0, N):
        command_list = list(map(int, input().split()))
        if command_list[0] == 0:
            rc_speed += 0
        elif command_list[0] == 1:
            rc_speed += command_list[1]
        else:
            rc_speed = max(0, rc_speed - command_list[1])

        sum += rc_speed
    
    print('#{} {}'.format(tc, sum))