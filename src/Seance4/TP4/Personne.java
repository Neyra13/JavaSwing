package Seance4.TP4;

public class Personne {
    private int id;
    private String nom;
    private String adress;

    public Personne(int id, String nom, String adress) {
        this(nom,adress);
        this.id = id;

    }


    public Personne(String nom, String adress) {
        this.nom = nom;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String address) {
        this.adress = address;
    }
}