L1= [1,2,3,4,5]
L2=[6,7,8,9,10]
L3=[]
for i in L1:
    if int(i)%2!=0:
        L3.append(i)

for j in L2:
    if int(j)%2==0:
        L3.append(j)

print(L3)
