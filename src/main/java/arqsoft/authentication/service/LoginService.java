package arqsoft.authentication.service;

import arqsoft.authentication.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginService {

    @PersistenceContext
    EntityManager entityManager;

    public boolean login(String username, String password) {
        User user = entityManager.createQuery
                ("SELECT * FROM username = '" + username + "' AND '" + password + "';", User.class)
                .getSingleResult();
        return user == null ? false : true;
    }
}