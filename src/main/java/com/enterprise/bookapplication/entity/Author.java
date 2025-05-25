package com.enterprise.bookapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
public class Author {

  @Id
  @Column(name = "authorId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer authorId;

  @Column(name = "authorName")
  private String authorName;

  @Column(name = "nation")
  private String nationality;

  @Column(name = "dateofbirth")
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp dateOfBirth;

  @Column(name = "createdAt")
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp createdAt;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Book> bookList = new ArrayList<>();

  public List<Book> getBookList() {
    return bookList;
  }

  public void setBookList(List<Book> bookList) {
    this.bookList = bookList;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Timestamp dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Integer authorId) {
    this.authorId = authorId;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
}
