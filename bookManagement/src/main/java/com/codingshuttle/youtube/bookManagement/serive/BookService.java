package com.codingshuttle.youtube.bookManagement.serive;

import com.codingshuttle.youtube.bookManagement.entity.Book;
import com.codingshuttle.youtube.bookManagement.repository.BookRepository;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository ;

    public BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository ;
    }

    //This method is used to create Book in DB .
    public Book createBook(Book bookReq) {
        Book bookRes =bookRepository.save(bookReq) ;
        return bookRes ;
    }


    //This Method is for to getBook by it's id ;
    public Book getBook(Long id) {
        Optional <Book> bookRes = bookRepository.findById(id);
        if (bookRes.isPresent()){
            return bookRes.get();
        }
        return null ;

    }


    public List<Book> getAllBooks() {

        List<Book> bookList = bookRepository.findAll();
        return bookList ;
    }

    public Book updateBook(Long id, Book bookRes) {
        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isEmpty()){
            return null ;
        }
        Book bookToSave = existingBook.get();
        bookToSave.setAuthor(bookRes.getAuthor());
        bookToSave.setTitle(bookRes.getTitle());
        bookToSave.setCategory(bookRes.getCategory());
        bookToSave.setPrice(bookRes.getPrice());

        return bookRepository.save(bookToSave);
    }


    public boolean deleteBook(Long id) {

        boolean isBook = bookRepository.existsById(id);
        if (!isBook) return false;

        bookRepository.deleteById(id);
        return true ;

    }
}
