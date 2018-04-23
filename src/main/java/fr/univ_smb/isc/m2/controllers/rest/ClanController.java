package fr.univ_smb.isc.m2.controllers.rest;

import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;
import fr.univ_smb.isc.m2.domain.clan.Clan;
import fr.univ_smb.isc.m2.domain.clan.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api")
public class ClanController {
    private final ClanService clanService;

    @Autowired()
    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }

    @RequestMapping(value = "/liste/Clan", method = POST, produces = "application/json;charset=UTF-8")
    public Clan createClan(@RequestBody Clan body) {
        return clanService.create(body.getName(), body.getLocalisation(),body.getFound());
    }

    @RequestMapping(value = "/liste/Clan", method = GET, produces = "application/json;charset=UTF-8")
    public List<Clan> allClan() {
        return clanService.all();
    }

    @RequestMapping(value = "/liste/Clan/{id}", method = GET, produces = "application/json;charset=UTF-8")
    public Clan clan(@PathVariable String id) {
        int clanId = parseInt(id);
        Clan clan = clanService.selectById(clanId);
        return Optional.ofNullable(clan).orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(value = "/liste/Clan", method = DELETE, produces = "application/json;charset=UTF-8")
    public void deleteClan(@PathVariable String id){
        int clanId = parseInt(id);
        clanService.delete(clanId);
    }

    @RequestMapping(value = "/liste/Clan/{id}", method = PUT, produces = "application/json;charset=UTF-8")
    public Clan modifieVaisseau(@PathVariable String id, double found ){
        int vaisseauId = parseInt(id);
        clanService.modifie(vaisseauId, found);
        return clanService.selectById(vaisseauId);
    }
}
