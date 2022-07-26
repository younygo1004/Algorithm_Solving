import math


T = int(input())

for tc in range(1, T+1):
    N = int(input())
    extracted_str = ''.join([(lambda x: x[0]*int(x[1]))(input().split()) for i in range(0, N)])

    print('#{}'.format(tc))
    for i in range(0, math.ceil(len(extracted_str)/10)):
        print(extracted_str[i*10:min((i+1)*10, len(extracted_str))])

