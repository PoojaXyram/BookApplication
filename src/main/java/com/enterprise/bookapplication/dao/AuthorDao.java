package com.enterprise.bookapplication.dao;

import com.enterprise.bookapplication.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {}
