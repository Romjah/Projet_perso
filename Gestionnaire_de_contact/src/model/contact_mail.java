package model;

import java.util.Comparator;

public class contact_mail implements Comparator<Contact>{
    public int compare(Contact e1, Contact e2) {
        return e1.getMail().compareTo(e2.getMail());
    }
}
