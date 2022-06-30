"""
Created by MinSeo on 2022/05/19.
Copyright ⓒ 2022 MinSeo Shin. All rights reserved.
"""
arr = []
n = int(input())
for i in range(n):
    arr.append(int(input()))

for i in range(1, len(arr)):
    key = i
    while arr[key-1] > arr[key] and key >= 1:
        arr[key-1], arr[key] = arr[key], arr[key-1]
        key -= 1
for a in arr:
    print(a)