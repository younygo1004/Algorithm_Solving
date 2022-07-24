T = int(input())

for tc in range(1, T+1):
    N = input()
    sorted_list = sorted(list(map(int, input().split())))
    print('#{}'.format(tc), end=' ')
    print(*sorted_list)