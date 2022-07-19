T = int(input())

for tc in range(1, T+1):
    num_list = list(map(int, input().split()))
    print('#{} {}'.format(tc, round((sum(num_list)-min(num_list)-max(num_list))/(len(num_list)-2))))