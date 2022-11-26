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

@Slf4j
@Component
public class EmployeProxy {

    @Autowired
    private CustomProperties customProperties;

    public Iterable<Employe> getEmployees(){

        String baseApiUrl = customProperties.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employes";

        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity<Iterable<Employe>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employe>>() {}
        );

        // log.debug("Get Employees call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public Employe createEmployee(Employe e){
        String baseApiUrl = customProperties.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employe";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employe> request = new HttpEntity<Employe>(e);
        ResponseEntity<Employe> response = restTemplate.exchange(
                createEmployeeUrl,
                HttpMethod.POST,
                request,
                Employe.class);

        // log.debug("Create Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update an employee - using the PUT HTTP Method.
     * @param e Existing employee to update
     */
    public Employe updateEmploye(Employe e) {
        String baseApiUrl = customProperties.getApiUrl();
        String updateEmployeeUrl = baseApiUrl + "/employe/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employe> request = new HttpEntity<Employe>(e);
        ResponseEntity<Employe> response = restTemplate.exchange(
                updateEmployeeUrl,
                HttpMethod.PUT,
                request,
                Employe.class);

        //log.debug("Update Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get an employee by the id
     * @param id The id of the employee
     * @return The employee which matches the id
     */
    public Employe getEmployee(int id) {
        String baseApiUrl = customProperties.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employe> response = restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.GET,
                null,
                Employe.class
        );

        // log.debug("Get Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }





}
