T = int(input())

change_unit = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

for tc in range(1, T+1):
    N = int(input())
    unit_cnt_list = []
    for unit in change_unit:
        cnt, N = divmod(N, unit)
        unit_cnt_list.append(cnt)
    
    print('#{}'.format(tc))
    print(*unit_cnt_list)