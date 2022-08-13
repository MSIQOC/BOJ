from collections import deque
s = int(input())
q = deque()
q.append([1, 0, 0])
v = dict()
v[(1, 0)] = 0

while q:
    h, c, t = q.popleft() #화면, 클립보드, 시간
    if h == s:
        print(t)
        break
    if h >= 1: #1번조건
        nh, nc = h, h
        if (nh, nc) not in v:
            v[(nh, nc)] = v[(h, c)] + 1
            q.append([nh, nc, t+1])
    if c >= 1: #2번조건
        nh, nc = h + c, c
        if (nh, nc) not in v:
            v[(nh, nc)] = v[(h, c)] + 1
            q.append([nh, nc, t + 1])
    nh, nc = h - 1, c #3번조건
    if nh >= 0 and (nh, nc) not in v:
        v[(nh, nc)] = v[(h, c)] + 1
        q.append([nh, nc, t + 1])

