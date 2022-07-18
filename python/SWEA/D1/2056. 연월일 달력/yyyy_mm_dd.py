from datetime import datetime

def print_yyyymmdd(t, year, month, day):
    print("#{} {}/{}/{}".format(t, year, month, day))

T = int(input())

for t in range(1, T+1):
    ymd = input()
    year, month, day = ymd[0:4], ymd[4:6], ymd[6:]
    
    if month == 2 and day == 29:
        print("#{} -1".format(t))
        continue

    try:
        datetime(int(year), int(month), int(day))
    except ValueError:
        print("#{} -1".format(t))
        continue
    
    print_yyyymmdd(t, year, month, day)