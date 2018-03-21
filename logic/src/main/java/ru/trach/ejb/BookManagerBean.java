package ru.trach.ejb;


import java.util.List;

import org.apache.log4j.Logger;
import ru.trach.domain.BookEntity;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class BookManagerBean {
   private final static Logger logger = Logger.getLogger(BookManagerBean.class);
     @PersistenceContext(unitName = "PUnit")
     protected EntityManager entityManager;
     
     public void create(BookEntity book) {
         logger.info(book.toString());
          entityManager.persist(book);

     }

     public List<BookEntity> getByGenre(String genre){
         logger.info("Query findAll" + BookEntity.FIND_ALL);
         TypedQuery<BookEntity> query = entityManager.createNamedQuery(BookEntity.GET_BY_GENRE,BookEntity.class);
         query.setParameter("genre",genre);
         return query.getResultList();
     }

     public List<BookEntity> findAll(){
         logger.info("Query findAll" + BookEntity.FIND_ALL);
          TypedQuery<BookEntity> query = entityManager.createNamedQuery(BookEntity.FIND_ALL,BookEntity.class);
          return query.getResultList();

     }
     
     public void remove(BookEntity book){
         logger.info("For Removing: " + book.toString());
          Query query = entityManager.createNamedQuery(BookEntity.REMOVE);
          query.setParameter("id", book.getId());
          query.executeUpdate();

     }
     
}
