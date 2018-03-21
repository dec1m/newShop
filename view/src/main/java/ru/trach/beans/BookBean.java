package ru.trach.beans;

import org.apache.log4j.Logger;
import ru.trach.domain.BookEntity;
import ru.trach.ejb.BookManagerBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@ManagedBean
@RequestScoped
public class BookBean {
    private String name;
    private String author;
    private String genre = "";
    private byte img[];
    private String description;
    private String isbn;
    private String publishing;
    private int price;
    private Part file;

    @EJB
    private BookManagerBean bookManager;
    private static final Logger logger = Logger.getLogger(BookBean.class);

    public void create() {
        BookEntity book = new BookEntity(name, author, img, genre,description, price, isbn, publishing);
        logger.info("Created Book:" + book);
        bookManager.create(book);
    }

    public List<BookEntity> findAll() {
        return bookManager.findAll();
    }

    public BookEntity getById(long id) {
        logger.info("GetByIdBook, id = " + id);
        //todo
        return null;
    }

    public List<BookEntity> getByGenre(){
       return bookManager.getByGenre(genre);
    }
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
        img = new byte[(int) file.getSize()];
        InputStream in = null;
        try {
            in = file.getInputStream();
            in.read(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
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


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }
}
