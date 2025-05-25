package com.enterprise.bookapplication.dao;


import com.enterprise.bookapplication.entity.Author;
import com.enterprise.bookapplication.entity.Book;
import com.enterprise.bookapplication.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor(Author author);

    List<Book> findByCategoryId(Integer id);
}
