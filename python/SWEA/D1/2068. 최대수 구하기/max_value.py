T = int(input())

for t in range(1, T+1):
    num_list = list(map(int, input().split()))
    print("#{} {}".format(t, max(num_list)))