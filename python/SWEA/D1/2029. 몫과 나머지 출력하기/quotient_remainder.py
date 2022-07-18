T = int(input())

for t in range(1, T+1):
    a, b = tuple(map(int, input().split()))
    quotient, remainder = divmod(a, b)
    print("#{} {} {}".format(t, quotient, remainder))