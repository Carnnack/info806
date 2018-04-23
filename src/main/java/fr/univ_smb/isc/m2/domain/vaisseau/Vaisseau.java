package fr.univ_smb.isc.m2.domain.vaisseau;

public class Vaisseau {

    public String name;
    public String type;
    public String nomCapitaine;
    public Integer taille;
    public Integer capacitePort;
    public Integer prix;
    public Integer id;

    private static int counter = 0;

    public Vaisseau() {
        this.name = "Interceptor";
        this.type = "Croisseur Impérial classe Interdictor";
        this.nomCapitaine = "Amiral Akbar";
        this.taille = 1200;
        this.capacitePort = 2000;
        this.id = 0;
        counter++;
    }

    public Vaisseau(Integer id, String name, String type, String nomCapitaine, Integer taille, Integer capacitePort, Integer prix) {
        this.name = name;
        this.type = type;
        this.nomCapitaine = nomCapitaine;
        this.taille = taille;
        this.capacitePort = capacitePort;
        this.prix = prix;
        this.id = id;
        counter++;
    }

    public Vaisseau(String name, String type,Integer taille, Integer capacitePort, Integer prix) {
        this.name = name;
        this.type = type;
        this.nomCapitaine = nomCapitaine;
        this.taille = taille;
        this.capacitePort = capacitePort;
        this.prix = prix;
        this.id = counter;
        counter++;
    }

    public Vaisseau(Integer id, String name, String type, Integer taille, Integer capacitePort, Integer prix) {
        this.name = name;
        this.type = type;
        this.taille = taille;
        this.capacitePort = capacitePort;
        this.prix = prix;
        this.id = id;
        counter++;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getNomCapitaine() {
        return nomCapitaine;
    }

    public void setNomCapitaine(String nomCapitaine) {
        this.nomCapitaine = nomCapitaine;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getCapacitePort() {
        return capacitePort;
    }

    public Integer getPrix() {
        return prix;
    }

    public int getId() {
        return id;
    }
}
