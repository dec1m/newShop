/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.trach.domain;

import java.io.Serializable;
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
    @Column(name = "img",nullable = false,length = 200)
    private String imgUrl = "default"; //todo Realise to Output File Image
    @Column(name = "description",nullable = false,length = 2000)
    private String description;
    @Column(name = "price",nullable = false)
    private int price;

    
    public static final String FIND_ALL = "BOOK_FIND_ALL";
    public static final String REMOVE = "BOOK_REMOVE";
    public static final String GET_BY_NAME = "BOOK_GET_BY_NAME";
    public static final String GET_BY_ID = "BOOK_GET_BY_ID";

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookEntity)) {
            return false;
        }
        BookEntity other = (BookEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public BookEntity(Long id,String name, String author, String imgUrl, String description, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.imgUrl = imgUrl;
        this.description = description;
        this.price = price;
    }
    public BookEntity(String name, String author, String imgUrl, String description, int price) {
        this.name = name;
        this.author = author;
        this.imgUrl = imgUrl;
        this.description = description;
        this.price = price;
    }

    public BookEntity() {
    }

    @Override
    public String toString() {
        return "ru.trach.domain.BookEntity[ id=" + id + " ]";
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
    
}