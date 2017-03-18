package arqsoft.authentication.service;

import arqsoft.authentication.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class LoginService {

    @PersistenceContext
    EntityManager entityManager;

    public boolean login(String username, String password) {
        List<User> users = entityManager.createQuery
                ("SELECT u FROM User u WHERE u.username LIKE '" + username + "' AND u.password LIKE '" + password + "'", User.class)
                .getResultList();

        return users.size() == 0 ? false : true;
    }
}