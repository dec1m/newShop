package ru.trach.auth.ejb;

import org.apache.log4j.Logger;
import ru.trach.auth.domain.User;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AuthenticationManager {
    private final static Logger logger = Logger.getLogger(AuthenticationManager.class);
    @PersistenceContext(unitName = "PUnit")
    private EntityManager entityManager;

    public boolean login(String email, String password) {
        logger.info(email + " " + password);
        if (email == null || password == null) { return false; }
        if (email.length() < 1 || password.length() < 1) { return false; }

        User user = entityManager.find(User.class, email);


        if (user == null) {return false;}
        if (!(password.equals(user.getPassword()))) {
            return false;}

        return true;


    }
}
