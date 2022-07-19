T = int(input())

for tc in range(1, T+1):
    palindrome = list(input().strip())
    
    is_palindrome = 0
    if palindrome == list(reversed(palindrome)):
        is_palindrome = 1

    print('#{} {}'.format(tc, is_palindrome))