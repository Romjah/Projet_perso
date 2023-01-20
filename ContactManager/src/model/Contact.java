package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private static final String SEPARATEUR = ";";

    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private Date dateNaissance;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) throws ParseException {
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]{2,}\\.[a-zA-Z.]{2,10}$");
        Matcher matcher = pat.matcher(mail);
        if (matcher.matches()) {
            this.mail = mail;
        } else {
            ParseException e = new ParseException("Le format du mail est incorrect.", 0);
            throw e;
        }
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) throws ParseException {
        Pattern pat = Pattern.compile("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$");
        Matcher matcher = pat.matcher(telephone);
        if (matcher.matches()) {
            this.telephone = telephone;
        } else {
            ParseException e = new ParseException("Le format du numéro est incorrect.", 0);
            throw e;
        }
    }

    public String getDateNaissance() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(dateNaissance);
    }

    public void setDateNaissance(String dateNaissance) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.dateNaissance = format.parse(dateNaissance);
    }

    public void enregistrer() throws IOException {
        /*
         * PrintWriter pw = new PrintWriter(new BufferedWriter(new
         * FileWriter("contacts.csv", true)));
         * try {
         * pw.println(this.toString());
         * } finally {
         * pw.close();
         * }
         */

        try (PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter("contacts.csv", true)))) {
            pw2.println(this.toString());
        }

    }

    public static ArrayList<Contact> lister() throws FileNotFoundException, IOException, ParseException {
        ArrayList<Contact> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("contacts.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Contact c = new Contact();
                c.setNom(tab[0]);
                c.setPrenom(tab[1]);
                c.setMail(tab[2]);
                c.setTelephone(tab[3]);
                c.setDateNaissance(tab[4]);
                list.add(c);
                ligne = buf.readLine();
            }
        }
        return list;
    }

    public static void sortByNameAndFirstName(ArrayList<Contact> contacts) {
        Collections.sort(contacts, (contact1, contact2) -> {
            int comp = contact1.getNom().compareTo(contact2.getNom());
            if (comp == 0) {
                comp = contact1.getPrenom().compareTo(contact2.getPrenom());
            }
            return comp;
        });
    }
    public static void sortByEmail(ArrayList<Contact> contacts) {
        contact_mail mail = new contact_mail();
        Collections.sort(contacts, mail);
    }

    public void supprimer() throws FileNotFoundException, IOException, ParseException {
        ArrayList<Contact> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("contacts.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Contact c = new Contact();
                c.setNom(tab[0]);
                c.setPrenom(tab[1]);
                c.setMail(tab[2]);
                c.setTelephone(tab[3]);
                c.setDateNaissance(tab[4]);
                list.add(c);
                ligne = buf.readLine();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNom().equals(this.getNom()) && list.get(i).getPrenom().equals(this.getPrenom())) {
                list.remove(i);
            }
        }
        try (PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter("contacts.csv", false)))) {
            for (int i = 0; i < list.size(); i++) {
                pw2.println(list.get(i).toString());
            }
        }
    }
    
    public void modifier() throws FileNotFoundException, IOException, ParseException {
        ArrayList<Contact> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("contacts.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Contact c = new Contact();
                c.setNom(tab[0]);
                c.setPrenom(tab[1]);
                c.setMail(tab[2]);
                c.setTelephone(tab[3]);
                c.setDateNaissance(tab[4]);
                list.add(c);
                ligne = buf.readLine();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNom().equals(this.getNom()) && list.get(i).getPrenom().equals(this.getPrenom())) {
                list.remove(i);
            }
        }
        try (PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter("contacts.csv", false)))) {
            for (int i = 0; i < list.size(); i++) {
                pw2.println(list.get(i).toString());
            }
        }
        try (PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter("contacts.csv", true)))) {
            pw2.println(this.toString());
        }
    }
    

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(this.getNom());
        build.append(SEPARATEUR);
        build.append(this.getPrenom());
        build.append(SEPARATEUR);
        build.append(this.getMail());
        build.append(SEPARATEUR);
        build.append(this.getTelephone());
        build.append(SEPARATEUR);
        build.append(this.getDateNaissance());
        return build.toString();
    }

    public static ArrayList<Contact> rechercher(String prenom2) {
        return null;
    }

}
