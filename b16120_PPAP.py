from collections import deque

s = input()
stack = deque()

for ss in s:
    stack.append(ss)
    if len(stack) >= 4 and stack[-4:] == ['P','P','A','P']:
        stack = stack[:-4]
        stack.append('P')


if stack == ['P']:
    print('PPAP')
else:
    print('NP')