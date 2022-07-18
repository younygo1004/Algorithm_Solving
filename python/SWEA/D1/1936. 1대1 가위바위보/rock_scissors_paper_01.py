A, B = tuple(map(int, input().split()))

winner = 'A'
if A == 1 and B == 2:
    winner = 'B'
elif A == 1 and B == 3:
    winner = 'A'
elif A == 2 and B == 1:
    winner = 'A'
elif A == 2 and B == 3:
    winner = 'B'
elif A == 3 and B == 1:
    winner = 'B'
elif A == 3 and B == 2:
    winner = 'A'

print(winner)