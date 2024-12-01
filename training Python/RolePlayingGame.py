from random import randint

COMPUTER_LIFE = PLAYER_LIFE = 50
PLAYER_POTION = 3

MENU_CHOICE = ["1", "2"]

while True:
    start_tour = ""

    while start_tour not in MENU_CHOICE:
        print("-" * 30)
        print("Votre tour : ")
        start_tour = input("Souhaitez vous attaquer (1) ou utiliser une potion (2) ? ")

    if start_tour == "1":
        degats = randint(5, 10)
        COMPUTER_LIFE -= degats

        if COMPUTER_LIFE < 0:
            print(f"!! L'ennemi est mort, vous avez gagné !!")
            print(f"Vous avez { PLAYER_LIFE } points de vie et l'ennemie a { COMPUTER_LIFE } points de vie")
            break
            
        print(f"Vous avez infligé { degats } points de degats à l'ennemi !")
        print(f"Vous avez { PLAYER_LIFE } points de vie")
        print(f"L'ennemi a { COMPUTER_LIFE } points de vie")

        

    elif start_tour == "2":
        if PLAYER_POTION > 0:
            PLAYER_POTION -= 1
            point_de_vie = randint(5, 50)
            PLAYER_LIFE += point_de_vie
            
            print(f"Vous avez obtenue { point_de_vie } points de vie")
            print(f"Vous avez { PLAYER_LIFE } points de vie")
            print(f"Il vous reste {PLAYER_POTION} potions")
        else:
            print("Vous n'avez plus de potion !")
            continue

    print("-" * 30)    
    print("Ennemi tour : ")
    degats = randint(5, 10)
    PLAYER_LIFE -= degats

    if PLAYER_LIFE < 0:
        print(f"Vous etes mort, l'ennemi a gagné ...")
        print(f"Vous avez { PLAYER_LIFE } points de vie")
        print(f"L'ennemi a { COMPUTER_LIFE } points de vie")
        break
    else:
        print(f"L'ennemi vous infligé { degats } points de degats")
        print(f"Vous avez { PLAYER_LIFE } points de vie")
        print(f"L'ennemi a { COMPUTER_LIFE } points de vie")
            
print("FIN DE LA PARTIE")
