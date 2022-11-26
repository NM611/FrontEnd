package sn.isi.service;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.model.Employe;
import sn.isi.model.User;
import sn.isi.repository.UserProxy;

@Data
@Service
public class UserService {

    @Autowired
    private UserProxy userProxy;

    public User saveClient(User user) {
        User savedCli;

        // Functional rule : Last name must be capitalized.


        if(user != null) {
            // If id is 0, then it is a new employee.
            savedCli = userProxy.createUserClient(user);
        } else {
            savedCli = null;

        }

        return savedCli;
    }
}
