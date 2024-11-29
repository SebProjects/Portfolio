import random
import sys

nbEssai = 5
nbAleatoire = random.randint(0, 100)

print("*** Le jeu du nombre mystére ***")

while nbEssai >= 1 :

	if nbEssai > 1:
		print(f"Il te reste { nbEssai } essais")
	else:
		print("Il te reste 1 essai")

	nbTest = input("Devine le nombre : ")
	while not nbTest.isdigit():
		nbTest = input("Devine le nombre : ")

	if int(nbTest) == nbAleatoire:
		print(f"Bravo ! Le nombre mystére était bien { nbAleatoire }")
		print(f"Tu as trouvé en { 6-nbEssai } essai")
		sys.exit()
	elif int(nbTest) < nbAleatoire:
		print(f"Le nombre mystére est plus grand que { nbTest }")
	elif int(nbTest) > nbAleatoire:
		print(f"Le nombre mystére est plus petit que { nbTest }")

	nbEssai -= 1

print(f"Dommage ! le nombre mystére était { nbAleatoire } ...")
print("Fin du jeu.")
print(" ")