T = int(input())

primes = (2, 3, 5, 7, 11)

for tc in range(1, T+1):
    N = int(input())
    factorization_result = []
    
    for prime in primes:
        cnt = 0
        while N % prime == 0:
            N //= prime
            cnt += 1
        factorization_result.append(cnt)
    
    print('#{}'.format(tc), end=' ')
    print(*factorization_result)
