package fr.utc.sr03.chat.dao;

import fr.utc.sr03.chat.model.User;
import org.springframework.stereotype.Repository;
//import org.apache.commons.lang3.StringEscapeUtils;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserService {

    @PersistenceContext
    EntityManager em;


    @Transactional
    public List<User> getAllUsers() {

        Query q = em.createQuery("select u from User u");

        return q.getResultList();

    }


    @Transactional
    public void addUser(User user) {
        user.getMail();
        em.persist(user);
    }

    @Transactional
    public void removeUser(User user) {

        em.remove(user);

    }

    @Transactional
    public void updateUser(User user) {

        em.merge(user);

    }

    @Transactional//requete sql
    public User getUser(String mail, String password, Boolean isAdmin) {
        //protection (et contraintes) à mettre dans front et end.


        Query q = em.createQuery("select u from User u where u.mail=:mail and u.password=:password and ( u.admin=:isAdmin or :isAdmin = false )" );
        //un admin peut se connecter en tant qu'utilisateur lambda (checkbox isAdmin = false)
        //mais un utilisateur lambda n'a pas le droit de se connecter en tant qu'admin (isAdmin = true alors que u.admin = false)
        q.setParameter("mail", mail);//.setParameter met en place toutes les protections pour nous
        q.setParameter("password", password);
        q.setParameter("isAdmin", isAdmin);

        try {
            return (User) q.getSingleResult();
        } catch (NoResultException exception) {
            System.out.println("Aucun utilisateur trouvé");
            return null;
        }
    }
}
