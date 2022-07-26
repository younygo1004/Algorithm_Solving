T = int(input())


for tc in range(1, T+1):
    garbage_num = input()
    num_list = list(map(int, input().split()))

    max_num = 0
    num_cnt = 0

    for i in range(0, 100+1):
        comp_num_cnt = num_list.count(i)
        if comp_num_cnt >= num_cnt:
            max_num = i
            num_cnt = comp_num_cnt

    print('#{} {}'.format(tc,max_num))
        