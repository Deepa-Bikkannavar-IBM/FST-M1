def fibonacci(num):
    if num<=1:
        return 1
    else:
        return(fibonacci(num-1)+fibonacci(num-2))

number=int(input("Enter the number :"))
for i in range(0,number):
    print(fibonacci(i))



