package com.enterprise.bookapplication.dao;

import com.enterprise.bookapplication.entity.Author;
import com.enterprise.bookapplication.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
  List<Book> findByAuthor(Author author);

  List<Book> findByCategoryId(Integer id);
}
