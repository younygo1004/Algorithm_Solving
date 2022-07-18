A, B = tuple(map(int, input().split()))

winner = 'A'

if A+B == 3 or A+B == 5:
    winner = 'A' if A > B else 'B'
else:
    winner = 'A' if A < B else 'B'

print(winner)