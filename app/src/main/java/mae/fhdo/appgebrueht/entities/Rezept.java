package mae.fhdo.appgebrueht.entities;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.entities.interfaces.IRezept;
import java.util.List;

/**
 * Created by Marvin Jakob.
 */

public class Rezept implements IRezept{

    private static int id_counter = 0;

    private int _id;
    private String titel;
    private int likes; // Gesamtanzahl der Likes
    private String beschreibung;
    private List<Integer> foto;

    private Rezept(){
        this._id = id_counter;
        id_counter++;
        this.likes = 0;
        this.beschreibung = "Neues Rezept";
    }

    public Rezept(String titel)
    {
        this();
        this.titel = titel;
    }

    public Rezept(String titel, String beschreibung)
    {
        this(titel);
        this.beschreibung = beschreibung;
    }

    public Rezept(String titel, String beschreibung , List<Integer> fotos)
    {
        this(titel, beschreibung);
        this.foto = fotos;
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

    public int getFoto() {
        if(foto != null && !foto.isEmpty()) return (foto.get(0)).intValue();
        else return R.drawable.first;
    }

    public void addFoto(int foto) {
        this.foto.add(foto);
    }

    public List<Integer> getFotos() { return foto;}
}
