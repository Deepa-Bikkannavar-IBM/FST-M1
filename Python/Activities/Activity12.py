def sumofnumbers(num):
    if num>0:
        sum = num+sumofnumbers(num-1)
        return sum
    else:
        return 0

print(sumofnumbers(3))
