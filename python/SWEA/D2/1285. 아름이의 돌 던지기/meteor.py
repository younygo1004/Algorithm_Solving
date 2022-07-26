T = int(input())

for tc in range(1, T+1):
    N = input()

    meteor_list = list(map(abs, list(map(int, input().split()))))
    print('#{} {} {}'.format(tc, min(meteor_list), meteor_list.count(min(meteor_list))))