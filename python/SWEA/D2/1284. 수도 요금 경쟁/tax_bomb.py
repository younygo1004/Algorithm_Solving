T = int(input())

for tc in range(1, T+1):
    P, Q, R, S, W = tuple(map(int, input().split()))

    company_A = W * P
    company_B = Q if W <= R else Q + ((W-R) * S)

    print('#{} {}'.format(tc, min(company_A, company_B)))