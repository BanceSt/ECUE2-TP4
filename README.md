# TP4 : Héritage

### Objectif
Utiliser l'héritage dans le cadre de la POO

- Sous-classe
- Classe Abstraite
- Interface

**On repart de la fin du TP3 (avec quelques légères adaptations). Les 3 classes Dessin, Rectangle et Point sont dans le projet ainsi que la classe Exec pour vos tests**

### Prérequis
- Cloner le projet sur votre poste dans le repertoire de votre choix
- Ouvrir le projet :
  - Sur l'écran d'accueil d'IntelliJ, cliquer sur **Open**
    Sélectionner le dossier de votre projet qui a été copié depuis GitHub puis cliquer sur OK.
  - Le projet s'ouvre
  - Allez vérifier que le SDK est bien sélectionné dans **File > Project Structure** onglet **Project**

### Utilisation de GIT

- Créer une nouvelle branche **prenomNom**
- Faire **1 commit** par exercice
- Ouvrir une *pull request* sur github :
  - Aller sur votre projet sur GitHub
  - Cliquer sur **New Pull Request**,
  - Sélectionner base repository = **harf18/ECUE2-TP4**
  - Sélectionner compare = votre branche **prenomNom**
----
----

### Exercice 1

Regarder le code des 3 classes pour vous rappeler le contexte : 
- Une classe Point 
- Une classe Rectangle qui utilise la classe Point.
- Une classe Dessin qui contient un tableau de rectangles.

Vous pouvez exécuter le main dans Exec et créer des rectangles et voir le plus grand rectangle, la surface et le périmètre de tous les rectangles.

On ajoute une nouvelle figure : **les disques**, un disque est caractérisé par son centre et son rayon.  
Créer une classe **Disque** avec les constructeurs adaptés ainsi que les méthodes :
- **translate(double x, double y)** : Déplace le disque
- **retourneSurface()** : Calcule et retourne la surface du disque
- **retournePerimetre()** : Calcule et retourne le perimètre du disque
- **contient(Point)** : Retourne vrai si le point est dans le disque. 
- **toString()** : Retourne une chaine qui décrit le disque.

> Pensez a faire un commit !!  


### Exercice 2
Modifier la classe **Dessin** pour qu'on puisse ajouter des **Disques** en plus des **Rectangles**. 
Attention, il ne faut pas rajouter un nouveau tableau, il faut créer une nouvelle classe abstraite (**Figure**) et faire en sorte que Disque et Rectangle soient des figures
Modifier le type du tableau et le type dans les méthodes actuelles pour qu'il soit possible d'ajouter aussi bien un **Disque** qu'un **Rectangle**. 
Pensez au polymorphisme...

Penser à modifier la méthode qui retourne le plus grand rectangle pour qu'elle retourne la plus grande **figure**.

> Pensez a faire un commit !!  


### Exercice 3
Dans la méthode **main()** de la classe **Exec** :
  - Effacer tout le contenu de la méthode main() mais laisser l'instanciation du dessin 
  - Créer des rectangles et des disques
  - Ajouter les au dessin
  - Afficher la surface totale des Figures
  - Afficher les informations de la plus grande figure
  - Créer un point, est ce qu'il est dans une figure ?

> Pensez a faire un commit !!  

### Exercice 4
Ajouter des **Triangles**. Un triangle est défini par 3 points. Ajouter tout ce qu'il faut pour que le triangle soit une figure.

- Pour calculer la surface d'un triangle sans connaitre sa hauteur, on peut utiliser la formule du héron ci-dessous où **s** est le demi périmètre et a, b, c la longueur de chaque coté.

![alt text](eq1.gif)

**Pensez à décomposer avec des méthodes (calcul des cotés, etc...) et à réutiliser les méthodes existantes
(périmètre, calcul des longueurs des côtés qui sont des distances entre 2 points)**


- Pour savoir si un point **M** appartient à un triangle, vous pouvez utiliser le théorème suivant où p est le périmètre et A, B, C sont les sommets et inf() retourne la plus petite valeur :


![alt text](eq2.gif)

**Pensez à décomposer avec des méthodes (récupération du plus petit coté, etc...) et à réutiliser les méthodes existantes**  

> Pensez a faire un commit !!  

### Exercice 5
Dans la méthode **main()** de la classe **Exec** :
  - Ajouter plusieurs Triangles
  - Afficher la surface totale des Figures
  - Afficher les informations de la plus grande figure

> Pensez a faire un commit !!  

### Exercice 6

On considère maintenant que les rectangles ne sont plus nécessairement parallèles aux axes. Un rectangle incliné est un rectangle avec un angle (en degrés),
mais il conserve les mêmes autres propriétés et méthodes qu'un rectangle (il a une longueur, une largeur, un point d'origine, il peut translater, etc...)

Créer une classe **RectangleIncline** qui hérite de **Rectangle** avec une propriété supplémentaire : *angle* et les constructeurs appropriés.
Rappelez-vous qu'un constructeur d'une classe fille doit appeler le constructeur de la classe parent avec *super(...)*

> Pensez a faire un commit !!


### Exercice 7
Redefinir les méthodes de la classe **RectangleIncline** qui le nécessitent (On veut connaitre l'angle du rectangle s'il est incliné lorsqu'on affiche les informations du rectangle...)   
Pour savoir si un point est dans un rectangle incliné, vous pouvez utiliser le code suivant :

```java
  public boolean contient(Point point) {
    double a = Math.toRadians(this.angle);
    double dx = point.x - this.point.x;
    double dy = point.y - this.point.y;
    double rotx =  dx * Math.cos(a) + dy * Math.sin(a);
    double roty = -dx * Math.sin(a) + dy * Math.cos(a);
    return 0 <= rotx && rotx <= this.longueur
            && 0 <= roty && roty <= this.largeur;
  }
```

> Pensez a faire un commit !!

### Exercice 8
Modifier si nécessaire la classe Dessin pour qu'on puisse ajouter des rectangles inclinés.
Ajouter des rectangles inclinés dans la méthode **main()** de la classe **Exec**

> Pensez a faire un commit (si nécessaire...) !!  
> Pensez à faire un push (```git push origin nomPrenom```)  
> Si elle n'est pas déjà ouverte, ouvrez une pull request (branche **prenomNom** vers **master**) NE PAS LA FERMER/MERGER !

### Exercice 9
Rajouter une classe carré

### Exercice 10

Finalement, avoir une classe RectangleIncline n'est pas forcément une bonne idée : un rectangle non incliné, c'est juste un rectangle avec un angle de 0°. Et si on veut des carrés inclinés, des triangles inclinés… faut-il créer une sous-classe à chaque fois ?

On va remplacer cet héritage par une **interface**.

- Créer une interface Inclinable avec deux méthodes :
  - getAngle() : retourne l'angle de la figure en degrés
  - pivoter(double degres) : ajoute l'angle passé en paramètre à l'angle de la figure
- Faire en sorte que Rectangle implémente l'interface Inclinable. Un rectangle a désormais un angle, égal à 0 par défaut.
- Adapter les constructeurs de Rectangle : garder ceux qui existent (angle à 0) et en ajouter un qui prend l'angle en paramètre.
- Déplacer dans Rectangle le code de RectangleIncline qui gère l'angle (contient(), toString(), equals()…), puis supprimer la classe RectangleIncline.
- Corriger la classe Exec pour qu'elle compile à nouveau.

**Questions (à répondre en commentaire dans l'interface Inclinable) :**

- Pourquoi l'attribut angle ne peut-il pas être déclaré dans l'interface ?
- Si vous créez une classe Carre qui hérite de Rectangle, peut-elle être inclinée ? Qu'avez-vous eu à écrire pour ça ?
- Un Disque doit-il implémenter Inclinable ? Et un Triangle ?

> Pensez a faire un commit !!

###  Exercice 11 (bonus)
Faire en sorte que Triangle implémente Inclinable : pivoter un triangle revient à faire tourner ses 3 points autour de son premier sommet.
Dans la classe Dessin, écrire une méthode pivoterTout(double degres) qui fait pivoter toutes les figures inclinables du dessin (et seulement elles). Utiliser instanceof.

> Pensez a faire un commit !!