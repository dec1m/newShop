package ru.trach.ejb;

import java.awt.print.Book;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class BookManagerBean {
     @PersistenceContext(unitName = "PUnit")
     EntityManager entityManager;
     
     public void create(String name,
                        String author,
                        String imgUrl,
                        String description,
                        int price){
      
         //todo
     }
     public List<Book> findAll(){
         
         return null;
     }
     
     public void remove(Book book){
         //todo
     }
     
}
