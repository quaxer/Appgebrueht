package mae.fhdo.appgebrueht.entities;

import mae.fhdo.appgebrueht.entities.interfaces.IBenutzer;

/**
 * Created by Marvin Jakob.
 */

public class Benutzer implements IBenutzer{
    private int _id;
    private String benutzername;
    private String eMail;
    private String Passwort;

    public Benutzer(String benutzername, String passwort) {
        this.benutzername = benutzername;
        Passwort = passwort;
    }

    public int get_id() {
        return _id;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }
}
