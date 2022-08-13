import heapq

t = int(input())

for tt in range(t):
    k = int(input())
    max_q = []
    min_q = []
    visited = [False for _ in range(k)]
    print(visited)
    for i in range(k):
        c, n = input().split()
        n = int(n)
        if c == 'I':
            heapq.heappush(min_q, (n, i))
            heapq.heappush(max_q, ((-n), i))
            visited[i] = True
        else:
            if c == '1':
                while max_q and not visited[max_q[0][1]]:
                    heapq.heappop(max_q)
                if max_q:
                    heapq.heappop(max_q)
                    visited[max_q[0][1]] = False
            else:
                while min_q and not visited[min_q[0][1]]:
                    heapq.heappop(min_q)
                if min_q:
                    heapq.heappop(min_q)
                    print(min_q[0][1])
                    visited[min_q[0][1]] = False
    while max_q and not visited[max_q[0][1]]:
        heapq.heappop(max_q)
    while min_q and not visited[min_q[0][1]]:
        heapq.heappop(min_q)
    if not min_q or not max_q:
        print('EMPTY')
    else:
        print(max_q, min_q)
        print(-max_q[0][0], min_q[0][0], sep = ' ')





