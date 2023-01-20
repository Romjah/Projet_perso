Pour le fichier APP.java :

Documentation : 
Ce code est une application Java qui permet à l'utilisateur de gérer une liste de contacts. 
Il contient une fonction principale, appelée main() qui affiche un menu pour l'utilisateur et gère les choix de l'utilisateur. 
Le menu comprend des options pour ajouter, lister, rechercher, modifier et supprimer un contact. 

La fonction ajouterContact() permet à l'utilisateur d'ajouter un contact à la liste. Elle demande à l'utilisateur de saisir le nom, le prénom, le mail, le numéro de téléphone et la date de naissance du contact et vérifie si les entrées sont valides. Si les entrées sont valides, le contact est ajouté à la liste.

La fonction listerContacts() affiche une liste de tous les contacts avec leurs informations. Elle prend un paramètre qui permet à l'utilisateur de trier les contacts par nom, mail ou date de naissance.

La fonction rechercherContact() permet à l'utilisateur de rechercher un contact en filtrant par prénom. Si le contact est trouvé, les informations du contact sont affichées. Sinon, un message indiquant qu'aucun contact n'a été trouvé est affiché.

La fonction modifierContact() permet à l'utilisateur de modifier un contact existant. Elle demande à l'utilisateur de saisir le nom et le prénom du contact à modifier et vérifie si le contact existe. Si le contact existe, l'utilisateur peut saisir les nouvelles informations du contact et le contact est mis à jour.

La fonction supprimerContact() permet à l'utilisateur de supprimer un contact de la liste. Elle demande à l'utilisateur de saisir le nom et le prénom du contact à supprimer et vérifie si le contact existe. Si le contact existe, il est supprimé de la liste.

Enfin, la fonction trierDate() permet à l'utilisateur de trier la liste des contacts par date de naissance. Elle trie la liste des contacts et affiche les informations des contacts triés.








Pour le ficher Contact.java :

Documentation :

Ce code est une classe Contact qui représente un contact d’un carnet d’adresse. Elle contient des attributs tels que le nom, le prénom, le mail, le numéro de téléphone et la date de naissance du contact.

Cette classe comprend plusieurs méthodes permettant de manipuler les contacts.

La méthode getNom() permet de récupérer le nom d'un contact.
La méthode setNom() permet de modifier le nom d'un contact.
La méthode getPrenom() permet de récupérer le prénom d'un contact.
La méthode setPrenom() permet de modifier le prénom d'un contact.
La méthode getMail() permet de récupérer le mail d'un contact.
La méthode setMail() permet de modifier le mail d'un contact. Elle vérifie le format du mail saisi. Si le format est incorrect, elle lève une exception.
La méthode getTelephone() permet de récupérer le numéro de téléphone d'un contact.
La méthode setTelephone() permet de modifier le numéro de téléphone d'un contact. Elle vérifie le format du numéro saisi. Si le format est incorrect, elle lève une exception.
La méthode getDateNaissance() permet de récupérer la date de naissance d'un contact.
La méthode setDateNaissance() permet de modifier la date de naissance d'un contact. Elle vérifie le format de la date saisie. Si le format est incorrect, elle lève une exception.
La méthode enregistrer() permet d'enregistrer un contact dans un fichier texte.
La méthode lister() permet de lister tous les contacts enregistrés dans le fichier texte et de les retourner sous forme d'une liste.
La méthode sortByNameAndFirstName() permet de trier la liste des contacts par nom et prénom.
La méthode sortByEmail() permet de trier la liste des contacts par mail.
La méthode supprimer() permet de supprimer un contact de la liste des contacts.
La méthode modifier() permet de modifier un contact dans la liste des contacts.
La méthode toString() permet de retourner un contact sous forme de chaîne de caractères.
La méthode rechercher() permet de rechercher un contact en fonction de son prénom.







Pour le fichier Contact_mail.java :

Documentation: 

Package model :
Ce package contient des classes qui servent à fournir des modèles pour les données.

Import java.util.Comparator :
Cet import permet d'importer des classes et des méthodes du package java.util qui contient des utilitaires pour les collections.

Public class contact_mail : 
Cette classe implémente l'interface Comparator pour comparer des objets Contact selon leurs adresses emails.

Méthode compare :
Cette méthode prend en paramètre deux objets Contact et renvoie un entier qui peut être négatif, positif ou 0. Elle compare les adresses emails des deux contacts et renvoie un entier en fonction de leurs différences. Si l'adresse email du premier contact est plus petite que celle du deuxième contact, elle renvoie un entier négatif. Si l'adresse email du premier contact est plus grande que celle du deuxième contact, elle renvoie un entier positif. Si les adresses email sont identiques, elle renvoie 0.