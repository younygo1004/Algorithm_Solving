# 제한시간 초과로 풀수 없음!
T = int(input())

def sum_profit_list(item_list):

    sum_profit = 0
    for i in range(0, len(item_list)):
        while i < len(item_list):
            sum_profit += item_list[i]
            i += 1

    return sum_profit

for tc in range(1, T+1):

    N = int(input())
    num_list = list(map(int, input().split()))

    profit_values_list = [num_list[x+1] - num_list[x] for x in range(0, len(num_list)-1)]
    minus_index_list = [index for index, x in enumerate(profit_values_list) if x < 0] 
    
    sum_profit = 0
    if len(minus_index_list) == 0 and sum(profit_values_list) > 0:
        sum_profit = sum_profit_list(profit_values_list)

    add_list = []
    if len(minus_index_list) > 0 and len(profit_values_list) > len(minus_index_list):
        add_list = [profit_values_list[:minus_index_list[0]]]
        add_list.extend([profit_values_list[item+1:minus_index_list[index+1]] for index, item in enumerate(minus_index_list) if index != (len(minus_index_list) - 1) ])
        add_list.append([x for x in profit_values_list[minus_index_list[len(minus_index_list)-1]:] if x > 0])

    for item in add_list:
        sum_profit += sum_profit_list(item)
    
    print("#{} {}".format(tc, sum_profit))
    

    