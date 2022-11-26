package sn.isi.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sn.isi.CustomProperties;
import sn.isi.model.Employe;

@Slf4j
@Component
public class LoginProxy {

    @Autowired
    private CustomProperties customProperties;

    public Employe getEmployeelogin(Employe e) {
        String baseApiUrl = customProperties.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/returnLogin";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employe> request = new HttpEntity<Employe>(e);
        ResponseEntity<Employe> response = restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.POST,
                request,
                Employe.class);

        // log.debug("Get Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }
}


