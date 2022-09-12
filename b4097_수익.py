while True: #n이 0일 때까지 반복이므로 while True문으로 작성 (무한 루프
    n = int(input()) #n 입력받음
    arr = []
    for i in range(n):
        arr.append(int(input()))
    if n == 0: #n이 0이면 while문 빠져나오기
        break
    else:
        D = [0 for _ in range(len(arr))] #배열 D 만들어주기
        D[0] = arr[0]
        for i in range(1, len(arr)): # i -> 1부터 arr을 길이까지 for문 돌려주기
            D[i] = max(D[i-1]+arr[i], arr[i]) #점화식
    print(max(D))