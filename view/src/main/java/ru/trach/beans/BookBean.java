package ru.trach.beans;

import ru.trach.domain.BookEntity;
import ru.trach.ejb.BookManagerBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class BookBean {
    private String name;
    private String author;
    private String imgUrl = "default";
    private String description;
    private int price;

    @EJB
    private BookManagerBean bookManager;


    public void create(){
        BookEntity book = new BookEntity(name,author,imgUrl,description,price);

        bookManager.create(book);
    }

    public List<BookEntity> findAll(){
        return bookManager.findAll();
    }

    public BookEntity getById(long id){
        //todo
        return  null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
