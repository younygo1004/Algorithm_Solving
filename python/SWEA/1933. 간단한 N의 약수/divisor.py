N = int(input())

answer = ''
for i in range(1, N//2+1):
    if N%i == 0:
        answer += str(i) + " "

print("{} {}".format(answer.strip(), N))