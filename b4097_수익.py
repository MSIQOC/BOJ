while True:
    n = int(input())
    arr = []
    for i in range(n):
        arr.append(int(input()))
    if n == 0:
        break
    elif n == 1:
        print(arr[0])
    else:
        D = [0 for _ in range(len(arr))]
        D[0] = arr[0]
        for i in range(1, len(arr)):
            D[i] = max(D[i-1]+arr[i], arr[i])
    print(max(D))