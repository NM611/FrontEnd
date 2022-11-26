package sn.isi.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sn.isi.CustomProperties;
import sn.isi.model.Employe;
import sn.isi.model.Profil;

@Slf4j
@Component
public class ProfilProxy {

    @Autowired
    private CustomProperties customProperties;

    public Iterable<Profil> getProfils(){

        String baseApiUrl = customProperties.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/profils";

        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity<Iterable<Profil>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Profil>>() {}
        );

        // log.debug("Get Employees call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public Profil getProfilUser(String libelle){

        String baseApiUrl = customProperties.getApiUrl();
        String getProfilUrl = baseApiUrl + "/getPro";

        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity<Profil> response = restTemplate.exchange(
                getProfilUrl,
                HttpMethod.GET,
                null,
                Profil.class
        );

        // log.debug("Get Profil call " + response.getStatusCode().toString());
        return response.getBody();
    }


}
