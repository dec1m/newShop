package ru.trach.ejb;

import org.apache.log4j.Logger;
import ru.trach.auth.domain.User;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class UserManagerBean {

    private final static Logger logger = Logger.getLogger(UserManagerBean.class);
    @PersistenceContext(unitName = "PUnit")
    private EntityManager entityManager;

    public void create(User user) {
        logger.info(user.toString());
        entityManager.persist(user);

    }

    public List<User> findAll() {
        logger.info("Query findAll" + User.FIND_ALL);
        TypedQuery<User> query = entityManager.createNamedQuery(User.FIND_ALL, User.class);
        return query.getResultList();

    }

    public void remove(User user) {
        logger.info("For Removing: " + user.toString());
        Query query = entityManager.createNamedQuery(User.REMOVE);
        query.setParameter("email", user.getEmail());
        query.executeUpdate();

    }

    public byte[] getImgByEmail(String email) {
        TypedQuery<byte[]> query = entityManager.createNamedQuery(User.GET_IMG_BY_EMAIL, byte[].class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    public User findByEmail(String  email){
        TypedQuery<User> query = entityManager.createNamedQuery(User.GET_BY_EMAIL, User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

}
