"""
참고: https://imzzan.tistory.com/40
처음에 tree를 이중리스트로 만들어서 원하는 지우고 싶은 노드를 delete 배열에 포함시키고 지우려 했지만 실패했다.
(방법이 살짝 잘못된 것 같다.)
"""
n = int(input())
arr = list(map(int, input().split()))
tree = [[] for _ in range(n)]
for i in range(1, len(arr)):
    tree[arr[i]].append(i)
number = int(input())
if number == 0:
    print(0)
    exit()
delete = []
q = []
q.append(number)
while q:
    a = q.pop(0)
    delete.append(a)
    for i in tree[a]:
        if i not in delete:
            delete.append(i)
            q.append(i)
for d in delete:
    for i in range(n):
        if d in tree[i]:
            tree[i].remove(d)
count = 0
for i in range(n):
    if not tree[i] and i not in delete:
        count += 1
print(count)