package arqsoft.authentication.service;

import arqsoft.authentication.model.User;
import arqsoft.authentication.utils.Tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LoginService {

    @PersistenceContext
    EntityManager entityManager;

    public User login(String username, String password) {

        List<User> users = entityManager.createQuery
                ("SELECT u FROM User u WHERE u.username LIKE '" + username + "' AND u.password LIKE '" + Tools.Encrypt(password) + "'", User.class)
                .getResultList();
        if(users.size() > 0){
            return users.get(0);
        }
        return null;
    }
}