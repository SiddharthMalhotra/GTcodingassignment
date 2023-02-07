'''
Original Code
'''


def multiplication(num_a, num_b):
    if num_a == 0 or num_b == 0:
        return 0
    return num_a + multiplication(num_a, num_b - 1)


'''
The code is logically correct, however it quickly overflows the stack memory due to recursion. 
We can see this as its unable to perform 4*4 digit calculation. There are several ways to improve this: 
1. Tail Recursion 
2. Utilizing bitwise operations 
'''

# print(multiplication(888, 888))  # correct response 788544
# print(multiplication(1111, 1111)) #RecursionError: maximum recursion depth exceeded in comparison

'''Improvment 1- Using tail recursion'''


def multiply(a, b, acc=0):
    if b == 0:
        return acc
    else:
        return multiply(a, b - 1, acc + a)


'''
Note: Python does not perform tail call optimization, however other language do the same- the logic would 
be to introduce an accumulator
'''
'''Improvment 2- Using bitwise operations'''

def multiply(a, b):
    result = 0
    while b:
        if b & 1:
            result += a
        a <<= 1
        b >>= 1
    return result

#print(multiply(1111, 1111)) Output: 1234321

