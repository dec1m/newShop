package ru.trach.ejb;


import java.util.List;
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
     @PersistenceContext(unitName = "PUnit")
     protected EntityManager entityManager;
     
     public void create(BookEntity book) {
          entityManager.persist(book);

     }

     public List<BookEntity> findAll(){
          TypedQuery<BookEntity> query = entityManager.createNamedQuery(BookEntity.FIND_ALL,BookEntity.class);
          query.executeUpdate();
          return query.getResultList();

     }
     
     public void remove(BookEntity bookEntity){
          Query query = entityManager.createNamedQuery(BookEntity.REMOVE);
          query.setParameter("id", bookEntity.getId());
          query.executeUpdate();
     }
     
}
