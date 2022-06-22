player1 = input("Enter name of player1")
player2= input("Enter name of player2")

player1_ans = input(player1 +"choose the scissor, rock or paper").lower()
player2_ans = input(player2 +"choose the scissor, rock or paper").lower()

print(player1_ans)
print(player2_ans)
if player1_ans==player2_ans:
    print("its a tie")
elif player1_ans=="scissor":
    if player2_ans=="rock":
        print(player2+" wins")
    else:
        print(player1+" wins")
elif player1_ans=="rock":
    if player2_ans=="scissor":
        print(player1+" wins")
    else:
        print(player2+" wins")
elif player1_ans=="paper":
    if player2_ans=="scissor":
        print(player2+" wins")
    else:
        print(player1+" wins")
else:
    print("invalid input")



