T = int(input())

for tc in range(1, T+1):
    num_check_list = [0 for x in range(0, 10)]

    N = int(input())
    x = 1
    while True:
        num_idx_list = list(map(int,list(str(x*N))))
        for num_idx in num_idx_list:
            num_check_list[num_idx] = 1
        if sum(num_check_list) == 10:
            break
        x += 1

    print('#{} {}'.format(tc, x*N))
