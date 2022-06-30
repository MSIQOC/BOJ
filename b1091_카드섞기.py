from copy import deepcopy

def check():
    for i in range(len(narr)):
        if narr[i] not in final[i%3]:
            return False
    return True

n = int(input())
p = list(map(int, input().split()))
s = list(map(int, input().split()))
final = [[] for _ in range(3)] #최종 답이 돼야할 배열 for i in range(len(s)):
for i in range(len(s)):
    final[p[i]].append(s[i])
arr = deepcopy(s)
narr = deepcopy(arr)
r = 0 #최소 몇번 섞어아하는지.
while not check(): #답 배열과 narr이 동일할 때 while문 나옴.
    arr = deepcopy(narr)
    for i in range(len(s)):
        narr[s[i]] = arr[i]
    if narr == s: #원래 s와 같게 되면 아무리 많이 섞어도 순서가 바뀌지 않음.
        r = -1
        break
    r += 1
print(r)