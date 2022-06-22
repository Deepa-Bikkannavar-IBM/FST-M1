Fruits = {
    "apple":10,
    "banana":20,
    "mango":30,
    "grapes":40,
    "orange":50
}
check = input("Enter the fruit to check whether it is available or not :").lower()
if check in Fruits:
    print(check+" is available")
else:
    print(check+" is not available")