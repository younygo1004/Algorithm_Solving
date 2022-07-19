T = int(input())

for tc in range(1, T+1):
    num_list = [x if x%2==1 else x*-1 for x in range(1, int(input())+1)]
    print('#{} {}'.format(tc, sum(num_list)))