package ru.trach.beans;

import ru.trach.domain.BookEntity;
import ru.trach.ejb.BookManagerBean;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BookBean {
    public BookEntity book = new BookEntity();

    @EJB
    private BookManagerBean bookManager;


    public void create(){
        bookManager.create(book);
    }
    public List<BookEntity> findAll(){
       return bookManager.findAll();
    }
    public BookEntity getById(long id){
       //todo
        return  null;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
