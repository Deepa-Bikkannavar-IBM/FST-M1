def sum_of_numbers(l1):
    sum=0
    for i in l1:
        sum=sum+int(i)
    print("sum of the numbers in list :"+str(sum))

num = list(input("Enter the numbers seperated by space :").split(" "))
sum_of_numbers(num)
