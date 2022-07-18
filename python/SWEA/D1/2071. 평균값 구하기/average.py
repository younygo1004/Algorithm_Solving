T = int(input())

for t in range(1, T+1):
    num_list = list(map(int, input().split()))

    print("#{} {}".format(t, round(sum(num_list) / len(num_list))))