r, c, q = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(r)] #배열
add = [[0 for _ in range(c+1)] for __ in range(r+1)] #누적합 배열

for i in range(r):
    for j in range(c):
        if j == 0:
            add[i+1][j+1] = arr[i][j]
        else:
            add[i+1][j+1] = add[i+1][j] + arr[i][j]


def average():
    sum, count = 0, 0  #sum: 밝기의 총 합.  count: 원소의 개수
    for i in range(r1, r2+1):
        sum += add[i][c2] - add[i][c1-1]
    count = (r2 - r1 + 1) * (c2 - c1 + 1) #사각형의 가로 x 세로
    print(sum // count)


for i in range(q):
    r1, c1, r2, c2 = map(int, input().split())
    average()