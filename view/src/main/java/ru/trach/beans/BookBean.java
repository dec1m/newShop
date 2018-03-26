package ru.trach.beans;

import org.apache.log4j.Logger;
import ru.trach.domain.BookEntity;
import ru.trach.ejb.BookManagerBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import javax.validation.constraints.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@ManagedBean
@RequestScoped
public class BookBean {
    private long id;
    @NotNull
    @Size(min = 5,max = 40,message = "Название должно быть от 5-50 символов")
    private String name;
    @NotNull
    @Size(min = 5,max = 40,message = "Имя автора должно быть от 5-40 символов")
    private String author;
    @NotNull
    @Size(min = 3,max = 20,message = "Згачение должно быть от 3-20 символов")
    private String genre;
    private byte img[];
    @NotNull
    @Size(min = 100,max = 5000,message = "Описание должно быть от 100-5000 символов")
    private String description;
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "ISBN должен быть, пример: 'ISBN 978-0-596-52068-7'")
    private String isbn;
    @NotNull
    @Size(min = 3,max = 10,message = "Згачение должно быть от 3-10 символов")
    private String publishing;
    @Min(value = 5,message = "Цена должна быть больше 5")
    @Max(value = 10000,message = "Цена должна быть меньше 10000")
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

    public void getById() {
      BookEntity book = bookManager.findById(id);
      name = book.getName();
      author = book.getAuthor();
      genre = book.getGenre();
      img = book.getImg();
      description = book.getDescription();
      publishing = book.getPublishing();
      isbn = book.getIsbn();
      price = book.getPrice();

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

    public List<String> findAllGenres(){
       return bookManager.getGenres();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
