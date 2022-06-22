num= list(input("Enter the numbers separated by space :").split(" "))
sum=0
for i in range(0, len(num)):
    sum+=int(num[i])
print(sum)