board = [list(map(int, list(input().rstrip()))) for _ in range(9)] #스도쿠 판
r, c, area = [[True for _ in range(10)] for __ in range(9)], [[True for _ in range(10)] for __ in range(9)], [[True for _ in range(10)] for __ in range(9)]
blank = [] #0인 좌표들 모아두는 곳

def backtracking(depth):
    if depth == len(blank):
        for i in range(9):
            for j in range(9):
                print(board[i][j], end='')
            print()
        exit(0)

    x, y = blank[depth][0], blank[depth][1]

    for i in range(1, 10): # ☆백트래킹을 이용한 순열
        if r[x][i] and c[y][i] and area[(x//3) * 3 + y//3][i]:
            r[x][i] = c[y][i] = area[(x//3)*3 + y//3][i] = False
            board[x][y] = i
            backtracking(depth + 1)
            r[x][i] = c[y][i] = area[(x//3) * 3 + y//3][i] = True
            board[x][y] = 0

for i in range(9):
    for j in range(9):
        if board[i][j] == 0: #0인 것들의 좌표
            blank.append([i, j])
        else:
            r[i][board[i][j]] = False
            c[j][board[i][j]] = False
            area[(i//3) * 3 + j//3][board[i][j]] = False

backtracking(0)