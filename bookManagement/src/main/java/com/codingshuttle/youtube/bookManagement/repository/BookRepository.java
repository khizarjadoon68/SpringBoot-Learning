package com.codingshuttle.youtube.bookManagement.repository;

import com.codingshuttle.youtube.bookManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
