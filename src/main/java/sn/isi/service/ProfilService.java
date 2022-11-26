package sn.isi.service;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.model.Employe;
import sn.isi.model.Profil;
import sn.isi.repository.ProfilProxy;

@Data
@Service
public class ProfilService {

    @Autowired
    private ProfilProxy profilProxy;

    public Iterable<Profil> getProfils() {
        return profilProxy.getProfils();
    }

    public Profil getObjProfil(String libelle){ return profilProxy.getProfilUser(libelle);}
}
