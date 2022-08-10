import sys

N = sys.stdin.readline()

sorted_list = sorted(map(int, sys.stdin.readline().strip().split()))

sum = 0
waiting = 0

for item in sorted_list:
    waiting += item
    sum += waiting

print(sum)