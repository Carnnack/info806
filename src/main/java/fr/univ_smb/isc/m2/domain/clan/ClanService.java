package fr.univ_smb.isc.m2.domain.clan;

import fr.univ_smb.isc.m2.domain.vaisseau.Vaisseau;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import fr.univ_smb.isc.m2.domain.customer.Customer;

import static java.util.stream.Collectors.toList;

@Service
public class ClanService {

    private final ArrayList<Clan> clans;

    public ClanService() {
        clans = new ArrayList<>();
        clans.add(new Clan("hut", "tatooin", 1000));
        clans.add(new Clan("empire", "centre", 100));
        clans.add(new Clan("soleil noir", "partout", 1000000));
    }

    public List<Clan> all() {
        return clans;
    }

    public Clan selectById(int clanId) {
        List<Clan> collect = clans.stream()
                .filter(u -> u.id == clanId)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }

    public Clan create(String name, String localisation, double found) {
        Clan clan = new Clan(name, localisation, found);
        clans.add(clan);
        return clan;
    }

    public void delete(int id) {
        Clan clan = selectById(id);
        clans.remove(clan);
    }

    public Clan modifie(int id, double found){
        int index = 0;
        while(clans.get(index).getId() != id && index <clans.size()){
            index++;
        }
        if (index < clans.size())
            clans.get(index).setFound(found);
        return clans.get(index);
    }
}