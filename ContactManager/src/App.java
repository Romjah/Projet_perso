import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;

import model.Contact;

public class App {

    private static Scanner _scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while (true) {
            afficherMenu();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    ajouterContact();
                    break;
                case "2":
                    listerContacts();
                    break;
                case "3":
                    rechercherContact();
                    break;
                case "4":
                    modifierContact();
                    break;
                case "5":
                    supprimerContact();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Boulet !!!");
                    break;
            }
        }
    }

    private static void listerContacts() {
        System.out.println(
                "\u  trier ? \u \033[m\n1- \033[32m⌈par nom⌋\033[30m \033[m\n2- \033[32m⌈par mail⌋\033[30m \033[m\n3- \033[32m⌈par date de naissance⌋\033[37m");
        String choix = _scan.nextLine();
        try {
            ArrayList<Contact> list = Contact.lister();
            switch (choix) {
                case "1":
                    Contact.sortByNameAndFirstName(list);
                    for (Contact contact : list) {
                        System.out.println("\033[33m" + contact.getNom() + " " + contact.getPrenom() + "\033[37m");
                    }
                    break;
                case "2":
                    Contact.sortByEmail(list);
                    for (Contact contact : list) {
                        System.out.println("\033[33m" + contact.getNom() + " " + contact.getPrenom() + " "
                                + contact.getMail() + "\033[37m");
                    }
                    break;
                case "3":
                    trierDate();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ajouterContact() throws IOException {
        Contact c = new Contact();
        System.out.println("\033[32m⌈Saisir le nom⌋\033[37m");
        c.setNom(_scan.nextLine());

        System.out.println("\033[32m⌈Saisir le prénom⌋\033[37m");
        c.setPrenom(_scan.nextLine());

        while (true) {
            try {
                System.out.println("\033[32m⌈Saisir le mail⌋\033[37m");
                c.setMail(_scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("\033[32m⌈Saisir le téléphone⌋\033[37m");
                c.setTelephone(_scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("\033[31m⌈Mauvais téléphone!⌋\033[37m");
            }
        }

        while (true) {
            try {
                System.out.println("\033[32m⌈Saisir la date de naissance⌋\033[37m");
                c.setDateNaissance(_scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("\033[31m⌈Mauvaise date de naissance!⌋\033[37m");
            }
        }
        c.enregistrer();
        System.out.println("\033[32m⌈Contact enregistré⌋\033[37m");

    }

    private static void rechercherContact() throws FileNotFoundException, IOException, ParseException {
        System.out.println("\033[32m⌈Saisir le prénom⌋\033[37m");
        String prenom = _scan.nextLine();
        ArrayList<Contact> list = Contact.lister();
        ArrayList<Contact> filteredList = (ArrayList<Contact>) list.stream()
                .filter(c -> c.getPrenom().startsWith(prenom))
                .collect(Collectors.toList());
        if (filteredList.isEmpty()) {
            System.out.println("\033[31m⌈Aucun contact trouvé avec ce prénom⌋\033[37m");
        } else {
            for (Contact contact : filteredList) {
                System.out.println(
                        "\033[32m" + contact.getNom() + " " + contact.getPrenom() + " " + contact.getTelephone() + " "
                                + contact.getMail() + "\033[37m");
            }
        }
    }

    private static void afficherMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("       \u27E4  MENU \u27E4");
        menus.add("\033[m1- \033[32m⌈Ajouter un contact⌋\033[37m");
        menus.add("\033[m2- \033[32m⌈Lister les contacts⌋\033[37m");
        menus.add("\033[m3- \033[32m⌈Recherche contact⌋\033[37m");
        menus.add("\033[m4- \033[32m⌈Modifier un contact⌋\033[37m");
        menus.add("\033[m5- \033[32m⌈Supprimer un contact⌋\033[37m");
        menus.add("\033[mq- \033[31m⌈Quitter⌋\033[30m");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    private static void modifierContact() throws FileNotFoundException, IOException, ParseException {
        System.out.println("\033[32m⌈Saisir le nom du contact à modifier⌋\033[37m");
        String nom = _scan.nextLine();
        System.out.println("\033[32m⌈Saisir le prénom du contact à modifier⌋\033[37m");
        String prenom = _scan.nextLine();
        ArrayList<Contact> list = Contact.lister();
        for (Contact contact : list) {
            if (contact.getNom().equals(nom) && contact.getPrenom().equals(prenom)) {
                Contact c = new Contact();
                System.out.println("\033[32m⌈Saisir le nouveau nom⌋\033[37m");
                c.setNom(_scan.nextLine());

                System.out.println("\033[32m⌈Saisir le nouveau prénom⌋\033[37m");
                c.setPrenom(_scan.nextLine());

                while (true) {
                    try {
                        System.out.println("\033[32m⌈Saisir le nouveau mail⌋\033[37m");
                        c.setMail(_scan.nextLine());
                        break;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.println("\033[32m⌈Saisir le nouveau numéro de téléphone⌋\033[37m");
                        c.setTelephone(_scan.nextLine());
                        break;
                    } catch (ParseException e) {
                        System.out.println("\033[31m⌈Mauvais téléphone!⌋\033[37m");
                    }
                }

                while (true) {
                    try {
                        System.out.println("\033[32m⌈Saisir la nouvelle date de naissance⌋\033[37m");
                        c.setDateNaissance(_scan.nextLine());
                        break;
                    } catch (ParseException e) {
                        System.out.println("\033[31m⌈Mauvaise date de naissance!⌋\033[37m");
                    }
                }
                contact.supprimer();
                c.enregistrer();
                System.out.println("\033[32m⌈Contact modifié⌋\033[37m");
            }
        }
    }

    private static void supprimerContact() throws IOException, ParseException {
        System.out.println("\033[32m⌈Saisir le nom du contact à supprimer⌋\033[37m");
        String nom = _scan.nextLine();
        System.out.println("\033[32m⌈Saisir le prénom du contact à supprimer⌋\033[37m");
        String prenom = _scan.nextLine();
        ArrayList<Contact> list = Contact.lister();
        for (Contact contact : list) {
            if (contact.getNom().equals(nom) && contact.getPrenom().equals(prenom)) {
                try {
                    contact.supprimer();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("\033[32m⌈Contact supprimé⌋\033[37m");
                return;
            }
        }
        System.out.println("\033[31m⌈Contact non trouvé⌋\033[37m");
    }

    private static void trierDate() {
        ArrayList<Contact> list;
        try {
            list = Contact.lister();
            Collections.sort(list, new Comparator<Contact>() {
                @Override
                public int compare(Contact o1, Contact o2) {
                    return o1.getDateNaissance().compareTo(o2.getDateNaissance());
                }
            });
            for (Contact contact : list) {
                System.out.println("\033[33m" + contact.getNom() + " " + contact.getPrenom() + " " + contact.getDateNaissance() + "\033[37m");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
