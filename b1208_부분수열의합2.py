"""
참고: https://ku-hug.tistory.com/190
"""

#함수 이름은 이해하기 쉽도록 작성했습니다.

import sys
from itertools import combinations
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

def getSumOfArrayCombination(array, newArray):
    for i in range(1, len(array)+1):
        for a in combinations(array, i):
            newArray.append(sum(a))


n, s = map(int, input().split())
arr = list(map(int, input().split()))
left, right = arr[:n//2], arr[n//2:]
leftSum, rightSum = [], []
getSumOfArrayCombination(left, leftSum)
getSumOfArrayCombination(right, rightSum)

answer = 0
rightSum.sort()
print(rightSum)

for l in leftSum:
    r = s - l
    answer += bisect_right(rightSum, r) - bisect_left(rightSum, r)

answer += leftSum.count(s)
answer += rightSum.count(s)

print(answer)