T = int(input())

for t in range(1, T+1):
    x, y = tuple(map(int, input().split()))
    symbol = '='
    if x > y:
        symbol = '>'
    elif x < y:
        symbol = '<'
    
    print("#{} {}".format(t, symbol))