T = int(input())

for tc in range(1, T+1):
    triangle_len = int(input())
    pascal_triangle_list = [[1], [1, 1]]

    for i in range(2, triangle_len):
        pascal_triangle_list.append([1, *[pascal_triangle_list[i-1][index] + pascal_triangle_list[i-1][index+1] for index in range(0, len(pascal_triangle_list[i-1])-1)], 1])
        
    print('#{}'.format(tc))
    for index in range(0, triangle_len):
        print(*pascal_triangle_list[index])
    
    
