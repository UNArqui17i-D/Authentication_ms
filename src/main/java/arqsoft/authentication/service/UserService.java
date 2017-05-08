package arqsoft.authentication.service;

import arqsoft.authentication.model.User;
import arqsoft.authentication.utils.Tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers(int first, int maxResult) {
        return entityManager.createNamedQuery(User.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public User getUserById(long id){
        return entityManager.find(User.class, id);
    }

    public User updateUser(long id, User user) {
        User userToUpdate = entityManager.find(User.class, id);
        userToUpdate.setName(user.getName());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());
        return entityManager.merge(userToUpdate);
    }

    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public User getUserByUsername(String username) {
        return entityManager.createQuery
                ("SELECT u FROM User u WHERE u.username LIKE '" + username + "'", User.class).getSingleResult();
        //return entityManager.find(User.class, username);
    }
}
