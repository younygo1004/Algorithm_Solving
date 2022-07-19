from random import randrange


T = int(input())

for tc in range(1, T+1):
    N, K = tuple(map(int, input().split()))

    word_cnt = 0

    puzzle = [input().split() for i in range(0, N)]
    puzzle_lengths = [list(map(lambda x: len(x), ''.join(item).split('0'))) for item in puzzle]
    word_cnt += str(puzzle_lengths).count(str(K))

    for j in range(0, N):
        for i in range(j, N):
            puzzle[i][j], puzzle[j][i] = puzzle[j][i], puzzle[i][j]
    
    puzzle_lengths = [list(map(lambda x: len(x), ''.join(item).split('0'))) for item in puzzle]
    word_cnt += str(puzzle_lengths).count(str(K))

    print('#{} {}'.format(tc, word_cnt))
