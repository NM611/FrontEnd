package sn.isi.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.model.Employe;
import sn.isi.repository.EmployeProxy;

@Data
@Service
public class EmployeService {

    @Autowired
    public EmployeProxy employeProxy;

    public Employe getEmploye(final int id) {
        return employeProxy.getEmployee(id);
    }

    public Iterable<Employe> getEmployes() {
        return employeProxy.getEmployees();
    }

    public Employe saveEmploye(Employe employe) {
        Employe savedEmploye;

        // Functional rule : Last name must be capitalized.
        employe.setPrenom(employe.getPrenom().toUpperCase());

        if(employe.getId() == 0) {
            // If id is 0, then it is a new employee.
            savedEmploye = employeProxy.createEmployee(employe);
        } else {
            savedEmploye = employeProxy.updateEmploye(employe);
        }

        return savedEmploye;
    }


}
