package mae.fhdo.appgebrueht.entities;

import mae.fhdo.appgebrueht.entities.interfaces.IRezept;

/**
 * Created by Marvin Jakob.
 */

public class Rezept implements IRezept{
    private int _id;
    private String titel;
    private int likes; // Gesamtanzahl der Likes
    private String beschreibung;

    public Rezept(String name)
    {
        this.titel = titel;
        this.likes = 0;
        this.beschreibung = "Neues Rezept";
    }

    public Rezept(String name, String beschreibung)
    {
        this.titel = titel;
        this.likes = 0;
        this.beschreibung = beschreibung;
    }

    public int getId() {
        return _id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
