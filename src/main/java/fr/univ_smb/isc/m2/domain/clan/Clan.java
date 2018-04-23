package fr.univ_smb.isc.m2.domain.clan;

import java.util.List;
import fr.univ_smb.isc.m2.domain.vaisseau.Vaisseau;

public class Clan {

    private String name;
    private List<Vaisseau> flote;
    private String localisation;
    private double found;
    public int id;

    private static int counter = 0;

    public String getName() {
        return name;
    }

    public String getLocalisation() {
        return localisation;
    }

    public double getFound() {
        return found;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setFound(double found) {
        this.found = found;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clan(String name, String localisation, double found) {
        this.name = name;
        this.localisation = localisation;
        this.found = found;
        id = counter++;
    }
}
