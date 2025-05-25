package com.enterprise.bookapplication.entity;


import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp publicationDate;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

//    @Column(name = "imageurl")
//    private URL coverImageUrl;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name="authorId")
    private  Author author;

    @OneToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    private Category category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

//    public URL getCoverImageUrl() {
//        return coverImageUrl;
//    }
//
//    public void setCoverImageUrl(URL coverImageUrl) {
//        this.coverImageUrl = coverImageUrl;
//    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
