T = int(input())

r = (0, 1, 0, -1)
c = (1, 0, -1, 0)

for tc in range(1, T+1):
    N = int(input())

    snail_list = [[0 for j in range(0, N)] for i in range(0, N)]

    snail_num = 1
    direction = 0
    r_idx = 0
    c_idx = 0
    snail_list[0][0] = 1

    while snail_num < N*N:

        for i in range(0, N):
            snail_list[r_idx][c_idx] = snail_num
            if r_idx+(1*r[direction]) >= N or c_idx+(1*c[direction]) >= N:
                break
            elif snail_list[r_idx+(1*r[direction])][c_idx+(1*c[direction])] > 0:
                break
            else:
                r_idx += (1*r[direction])
                c_idx += (1*c[direction])
                snail_num += 1

        direction = (direction+1) % 4
    
    print('#{}'.format(tc))
    for item in snail_list:
        print(*item)