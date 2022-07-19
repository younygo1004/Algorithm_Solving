import re

N = int(input())
num_list = [str(x) for x in range(1, N+1)]
find_369 = re.compile('3|6|9')

for index, item in enumerate(num_list):
    if find_369.search(item):
        num_list[index] = '-' * len(find_369.findall(item))

print(*num_list)

