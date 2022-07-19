T = int(input())

for tc in range(1, T+1):
    test_str = '123456789'
    sudoku = [input().split() for i in range(9)]
    
    is_sudoku = 1

    for item in sudoku:
        if test_str != ''.join(sorted(item)):
            is_sudoku = 0
            break

    if is_sudoku == 1:
        for i in range(0, 9):
            piece_sudoku = [item[i] for item in sudoku]
            if test_str != ''.join(sorted(piece_sudoku)):
                is_sudoku = 0
                break

    if is_sudoku == 1:
        for i in range(0, 9, 3):
            piece_sudoku = sudoku[i:i+3]
            for j in range(0, 9, 3):
                check_list = sorted([num for item in piece_sudoku for num in item[j:j+3]])
                if test_str != ''.join(sorted(check_list)):
                    is_sudoku = 0
                    break
    
    print('#{} {}'.format(tc, is_sudoku))