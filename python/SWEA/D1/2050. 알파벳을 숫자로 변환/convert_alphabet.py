text = input()

alphabet_list = [str(ord(text[x]) - 64) for x in range(0, len(text))]

print(" ".join(alphabet_list).strip())