select = 0
liste = []



while not select == 5:
	print("------------------------")
	print("Choisissez parmi les 5 options suivantes : ")
	print("1: Ajouter un élément à la liste")
	print("2: Retirer un élément de la liste")
	print("3: Afficher la liste")
	print("4: Vider la liste")
	print("5: Quitter")

	select = int(input("Votre choix : "))

	if (select == 1):
		liste.append(input("Entrez le nom d'un élément à ajouter à la liste de courses : "))
	elif (select == 2):
		liste.remove(input("Entrez le nom d'un élément à retirer de la liste de courses : "))
	elif (select == 3):
		print("Voici le contenu de votre liste : ")
		for i in range(len(liste)):
			print(f"{i}. {liste[i]}")
	elif (select == 4):
		liste.clear()
	
