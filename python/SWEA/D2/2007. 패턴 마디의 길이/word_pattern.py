T = int(input())

for tc in range(1, T+1):
    text = input().strip()
    for i in range(1, 10):
        sliced_text = text.split(text[:i])
        if sliced_text[1] == '' and text[:len(sliced_text[len(sliced_text)-1])] == sliced_text[len(sliced_text)-1]:
            print('#{} {}'.format(tc, i))
            break
