package beans;

import entity.UserTableEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class AddUser {
    //System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    @PersistenceContext
    EntityManager em = emf.createEntityManager();

    public void CreateUser(String username, String password, int role, String email){
    UserTableEntity user = new UserTableEntity();

    user.setUsername(username);
    user.setPassword(password);
    user.setIdRole(role);
    user.setIdState(1);
    user.setEmail(email);

    em.getTransaction().begin();
    em.persist(user);
    em.getTransaction().commit();


    em.close();
    emf.close();
    }
}
