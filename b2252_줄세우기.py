#
# Created by MinSeo on 2022/03/08.
# Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
#
from collections import defaultdict, deque

n, m = map(int, input().split()) #input 정의해주기

arr = defaultdict(list) #위상정렬을 위한 배열 생성
count = [0] * (n+1) #진입차수 카운팅 해주기 위한 배열 생성

for i in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    count[b] += 1

result = []
q = deque()

for i in range(len(count)):
    if count[i] == 0:
        q.append(i)
        result.append(i)

while q:
    v = q.popleft()
    for a in arr[v]:
        count[a] -= 1
        if count[a] == 0:
            q.append(a)
            result.append(a)
result.pop(0)
for r in result:
    print(r, end=' ')




