from datetime import datetime

time_1 = datetime.strptime('05:00', "%M:%S")
time_2 = datetime.strptime('01:00', "%M:%S")
s = time_2-time_1
print(str(s)[11:])
n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(str, input().split())))
    arr[i][0] = int(arr[i][0])
dictionary = {
    1: 0,
    2: 0
}
start = arr[0][1]
who_wins = arr[0][0]
f_r, r_r = 0, 0
for i in range(0, n):
    dictionary[arr[i][0]] += 1
    if max(dictionary) != who_wins:
        time_1 = datetime.strptime(start, "%M:%S")
        time_2 = datetime.strptime(arr[i][1], "%M:%S")
        s = time_2 - time_1
        f_r += datetime.strptime(str(s)[11:], "%M:%S")
