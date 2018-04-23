package fr.univ_smb.isc.m2.controllers.rest;


import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;
import fr.univ_smb.isc.m2.domain.vaisseau.Vaisseau;
import fr.univ_smb.isc.m2.domain.vaisseau.VaisseauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api")
public class VaisseauController {
    private final VaisseauService vaisseauService;

    @Autowired()
    public VaisseauController(VaisseauService vaisseauService) {
        this.vaisseauService = vaisseauService;
    }

    @RequestMapping(value = "/liste/Vaisseau", method = POST, produces = "application/json;charset=UTF-8")
    public Vaisseau createVaisseau(@RequestBody Vaisseau body) {
        return vaisseauService.create(body.getName(), body.getType(),body.getTaille(), body.getCapacitePort(), body.getPrix());
    }

    @RequestMapping(value = "/liste/Vaisseau", method = GET, produces = "application/json;charset=UTF-8")
    public List<Vaisseau> allVaisseau() {
        return vaisseauService.all();
    }

    @RequestMapping(value = "/liste/Vaisseau/{id}", method = GET, produces = "application/json;charset=UTF-8")
    public Vaisseau vaisseau(@PathVariable String id) {
        int vaisseauId = parseInt(id);
        Vaisseau vaisseau = vaisseauService.selectById(vaisseauId);
        return Optional.ofNullable(vaisseau).orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(value = "/liste/Vaisseaux", method = DELETE, produces = "application/json;charset=UTF-8")
    public void deleteVaisseau(@PathVariable String id){
        int vaisseauId = parseInt(id);
        vaisseauService.delete(vaisseauId);
    }

    @RequestMapping(value = "/liste/Vaisseaux/{id}", method = PUT, produces = "application/json;charset=UTF-8")
    public Vaisseau modifieVaisseau(@PathVariable String id, String nameCaptain ){
        int vaisseauId = parseInt(id);
        vaisseauService.modifie(vaisseauId, nameCaptain);
        return vaisseauService.selectById(vaisseauId);
    }


}
