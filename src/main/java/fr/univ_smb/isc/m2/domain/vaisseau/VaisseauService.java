package fr.univ_smb.isc.m2.domain.vaisseau;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



import static java.util.stream.Collectors.toList;

@Service
public class VaisseauService {

    private final ArrayList<Vaisseau> vaisseaux;

    public VaisseauService() {
        vaisseaux = new ArrayList<>();
        vaisseaux.add(new Vaisseau(0,"Clovus","interdictor",200,150,2000));
        vaisseaux.add(new Vaisseau(1,"Dark","Vador",100,250,200));
        vaisseaux.add(new Vaisseau(2,"Vador","Dark",250,350,2400));
        vaisseaux.add(new Vaisseau(3,"Empereur","Sith",260,50,2100));
        vaisseaux.add(new Vaisseau(4,"Luke","Sabre",270,150,3000));
        vaisseaux.add(new Vaisseau(5,"Yoda","Vert",280,750,5000));

    }

    public List<Vaisseau> all() {
        return vaisseaux;
    }

    public Vaisseau selectById(int vaisseauId) {
        List<Vaisseau> collect = vaisseaux.stream()
                .filter(u -> u.id == vaisseauId)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }

    public Vaisseau create(String name, String type, Integer taille, Integer capacitePort, Integer prix) {
        Vaisseau vaisseau = new Vaisseau(name,type,taille,capacitePort,prix);
        vaisseaux.add(vaisseau);
        return vaisseau;
    }

    public void delete(Integer id){
        int index = 0;
        while(vaisseaux.get(index).getId() != id && index <vaisseaux.size()){
            index++;
        }
        if (index < vaisseaux.size())
            vaisseaux.remove(index);
    }

    public Vaisseau modifie(int id, String nomCapitaine){
        int index = 0;
        while(vaisseaux.get(index).getId() != id && index <vaisseaux.size()){
            index++;
        }
        if (index < vaisseaux.size())
            vaisseaux.get(index).setNomCapitaine(nomCapitaine);
        return vaisseaux.get(index);
    }

}