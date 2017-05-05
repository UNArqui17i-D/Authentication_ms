package arqsoft.authentication.service;

import arqsoft.authentication.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RegisterService {

    @PersistenceContext
    EntityManager entityManager;

    public void registerUser(User user) {
        entityManager.persist(user);
    }
}
