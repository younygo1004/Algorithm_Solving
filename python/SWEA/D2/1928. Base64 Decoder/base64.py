T = int(input())

base64_table = {
    'A' : 0,
    'a' : 26,
    '0' : 52,
    '+' : 62,
    '/' : 63
}

def to_binary(encoded_str):

    cal_str = ''

    if encoded_str.isupper():
        cal_str = 'A'
    elif encoded_str.islower():
        cal_str = 'a'
    elif encoded_str.isdecimal():
        cal_str = '0'

    binary_str = bin(base64_table[cal_str] + (ord(encoded_str) - ord(cal_str)))[2:]
    return '0'*(6-len(binary_str)) + binary_str


for tc in range(1, T+1):
    encoded_str = input()
    split_list = [list(encoded_str[index:index+4]) for index in range(0, len(encoded_str), 4)]
    binary_str = ''.join([to_binary(alpha) for item in split_list for alpha in item])
    binary_list = [chr(int(binary_str[index:index+8], 2)) for index in range(0, len(binary_str), 8)]
    
    decoded_str = ''.join(binary_list)
    print('#{} {}'.format(tc, decoded_str))