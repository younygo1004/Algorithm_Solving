N = int(input())

num_list = [str(x) for x in range(1, N+1)]

for index, item in enumerate(num_list):
    if '3' in item or '6' in item or '9' in item:
        num_list[index] = '-' * (item.count('3') + item.count('6') + item.count('9'))

print(*num_list)