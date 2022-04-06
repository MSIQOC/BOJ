n, k = map(int, input().split())
D = [[0 for _ in range(201)] for __ in range(201)]
for i in range(n+1):
    D[1][i] += 1
for kk in range(2, k+1):
    for i in range(n+1):
        for j in range(i+1):
            D[kk][i] = D[kk-1][i-j] % 1000000000
            D[kk][i] = D[kk][i] % 1000000000

print(D[k][n])