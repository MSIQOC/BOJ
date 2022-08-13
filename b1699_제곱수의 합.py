n = int(input())
D = [999999 for _ in range(100001)]
D[0], D[1] = 0, 1
for i in range(2, 100001):
    j = 1
    while j*j <= i:
        D[i] = min(D[i], D[i-j*j])
        j += 1
    D[i] += 1
print(D[n])