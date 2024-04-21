Question 1:Dans un test pour automatiser la méthode jouer de la classe Jeu, les objets qui dépendent de la classe Jeu et qui sont forcément mockés sont :
Les dés (De)  : pour simuler le lancer des dés et obtenir une somme.
Le joueur (Joueur) : pour simuler les interactions avec le joueur, telles que la mise, le débit et le crédit d'argent.
La banque (Banque) : pour simuler les interactions avec la banque, telles que le crédit et le débit d'argent, ainsi que la vérification de la solvabilité de la banque.
Question 2 :Scénarios pour tester la méthode jouer :
Cas où le jeu est ouvert et la somme des lancers des dés ne vaut pas 7.
Cas où le jeu est ouvert et la somme des lancers des dés vaut 7.
Cas où le jeu est fermé.
Cas où le joueur est insolvable.
Cas où la banque devient insolvable après un gain.

Question 3 :Le test le plus simple serait celui où le jeu est fermé. 
C'est un test d'état, car il vérifie simplement si le jeu est fermé sans interagir avec les dés, le joueur ou la banque.

Question 4 :Pour tester le cas où le joueur est insolvable sans toucher aux dés, 
nous pouvons simuler une situation où le joueur n'a pas assez d'argent pour miser. 
Nous vérifierons ensuite que le jeu ne touche pas aux dés en vérifiant que la méthode lancer() des dés n'est pas appelée. 
C'est un test d'état, car il vérifie simplement si le joueur est insolvable sans interagir avec les autres objets.

Question 5 :Pour écrire une implémentation pour la banque, nous devons créer une classe qui implémente l'interface Banque. 
Cette implémentation devrait inclure la gestion du fond de la banque, ainsi que la vérification de la solvabilité. 
Ensuite, dans un test impliquant la banque, nous intégrerions cette implémentation pour simuler les interactions avec la banque,
telles que le crédit et le débit d'argent, ainsi que la vérification de la solvabilité.
La différence entre les deux tests serait que dans le premier, nous simulerions les interactions avec la banque à l'aide de mocks, 
tandis que dans le second, nous utiliserions une implémentation réelle de la banque pour tester son comportement réel.
