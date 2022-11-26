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
import sn.isi.model.User;

@Slf4j
@Component
public class UserProxy {
    @Autowired
    private CustomProperties customProperties;

    public User createUserClient(User u){
        String baseApiUrl = customProperties.getApiUrl();
        String createUserUrl = baseApiUrl + "/userCli";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<User>(u);
        ResponseEntity<User> response = restTemplate.exchange(
                createUserUrl,
                HttpMethod.POST,
                request,
                User.class);

        // log.debug("Create Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }
}
