#
# Created by MinSeo on 2022/02/18.
# Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
#

tt = int(input())
for t in range(tt):
    ii = int(input())
    arr = []
    for i in range(ii):
        arr.append(input())
    arr.sort()
    torf = True
    for i in range(len(arr)-1):
        if arr[i] == arr[i+1][:len(arr[i])]:
            torf = False
            break
    if torf:
        print('YES')
    else:
        print('NO')



