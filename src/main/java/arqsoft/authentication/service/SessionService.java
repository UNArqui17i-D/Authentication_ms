<<<<<<< HEAD
package arqsoft.authentication.service;

import arqsoft.authentication.model.Session;
import arqsoft.authentication.model.User;
import arqsoft.authentication.utils.Tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.SecureRandom;
import java.util.List;

@Stateless
public class SessionService {

    @PersistenceContext
    EntityManager entityManager;

    public Session getSessionByUserId(long userId){
        return entityManager.find(Session.class, userId);
    }

    public Session createSession(Session session) {
        try {
            SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[20];
            random.nextBytes(bytes);
            String token = bytes.toString();
            session.setToken(token);
            entityManager.persist(session);
            return session;
        }catch(Exception e){
            return null;
        }
    }

    public void deleteSession(long userId) {

        Session session = entityManager.createQuery
                ("SELECT u FROM Session u WHERE u.userId LIKE " + userId, Session.class).getSingleResult();
        entityManager.remove(session);
        /*Session session = entityManager.find(Session.class, token);
        entityManager.remove(session);*/
    }
=======
package arqsoft.authentication.service;

import arqsoft.authentication.model.Session;
import arqsoft.authentication.model.User;
import arqsoft.authentication.utils.Tools;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.SecureRandom;
import java.util.List;

@Stateless
public class SessionService {

    @PersistenceContext
    EntityManager entityManager;

    public Session getSessionByUserId(long userId){
        return entityManager.find(Session.class, userId);
    }

    public Session createSession(Session session) {

        try {
            SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[20];
            random.nextBytes(bytes);
            String token = bytes.toString();
            session.setToken(token);
            entityManager.persist(session);
            return session;
        }catch(Exception e){
            return null;
        }
    }

    public void deleteSession(long userId) {
        Session session = entityManager.createQuery
                ("SELECT u FROM Session u WHERE u.userId LIKE " + userId, Session.class).getSingleResult();
        entityManager.remove(session);
        /*Session session = entityManager.find(Session.class, token);
        entityManager.remove(session);*/
    }
>>>>>>> e9b88ec879fb8d23b05a09883ce950fd0d5e9c8a
}