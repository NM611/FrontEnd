package sn.isi.service;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.model.Employe;
import sn.isi.repository.LoginProxy;

@Data
@Service
public class LoginService {


    @Autowired
    public LoginProxy loginProxy;

    public Employe getEmployeeLogin(Employe employe){
        return loginProxy.getEmployeelogin(employe);

    }


}
