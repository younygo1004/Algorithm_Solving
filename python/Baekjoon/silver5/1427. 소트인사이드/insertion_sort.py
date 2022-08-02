import sys

num_list = list(map(int, list(sys.stdin.readline().strip())))

for key in range(1, len(num_list)):
    for i in range(key, 0-1, -1):
        if num_list[i] <= num_list[key]:
            num_list[key], num_list[i] = num_list[i], num_list[key]
            key = i
        else:
            break

for item in num_list:
    print(item, end='')
    
