/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.trach.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author decim
 */
@Entity
@SuppressWarnings("ALL")
@NamedQueries({
        @NamedQuery(name= BookEntity.GET_BY_NAME, query = "SELECT b FROM BookEntity b WHERE b.name = :name"),
        @NamedQuery(name= BookEntity.REMOVE, query = "DELETE FROM BookEntity b WHERE b.id = :id"),
        @NamedQuery(name= BookEntity.FIND_ALL, query = "SELECT b FROM BookEntity b"),
        @NamedQuery(name= BookEntity.GET_BY_ID, query = "SELECT b FROM BookEntity b WHERE b.id = :id")
})
@Table(name = "Books")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "name",nullable = false,length = 100)
    private String name;
    @Column(name = "author",nullable = false,length = 200)
    private String author;
    @Lob
    @Column(name = "img",nullable = false)
    private byte[] img;
    @Column(name = "ganre",nullable = false,length = 20)
    private String ganre ;
    @Column(name = "description",nullable = false,length = 2000)
    private String description;
    @Column(name = "price",nullable = false)
    private int price;

    
    public static final String FIND_ALL = "BOOK_FIND_ALL";
    public static final String REMOVE = "BOOK_REMOVE";
    public static final String GET_BY_NAME = "BOOK_GET_BY_NAME";
    public static final String GET_BY_ID = "BOOK_GET_BY_ID";


    public BookEntity() {
    }

    public BookEntity(Long id,String name, String author,byte[]  img, String description,String ganre, int price) {
        this.name = name;
        this.ganre = ganre;
        this.author = author;
        this.img = img;
        this.description = description;
        this.price = price;
    }

    public BookEntity(String name, String author, byte[] img, String description,String ganre, int price) {
        this.name = name;
        this.ganre = ganre;
        this.author = author;
        this.img = img;
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return price == that.price &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(author, that.author) &&
                Objects.equals(img, that.img) &&
                Objects.equals(ganre, that.ganre) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, author, img, ganre, description, price);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", ganre='" + ganre + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGanre() {
        return ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }
}