st = [1, 2, 3, 4, 5]

t = 0
while True:
    t += 1
    stack = []
    s = input()
    if '-' in s:
        break
    for st in s:
        stack.append(st)
        if len(stack) >= 2 and stack[-2:] == ['{', '}']:
            stack.pop()
            stack.pop()
    count = 0
    while stack:
        if stack[-1] == '{':
            stack[-1] = '}'
            count += 1
        if stack[-2] == '}':
            stack[-2] = '{'
            count += 1
        stack.pop()
        stack.pop()
    print(t,'. ', count, sep='')
