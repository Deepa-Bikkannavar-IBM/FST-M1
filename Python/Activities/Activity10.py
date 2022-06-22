num = tuple(input("Enter the numbers seperated by space :").split(" "))
for i in num:
    if int(i)%5==0:
        print(i)