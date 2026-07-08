package com.codingshuttle.youtube.bookManagement.controller;

import com.codingshuttle.youtube.bookManagement.entity.Book;
import com.codingshuttle.youtube.bookManagement.serive.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private BookService bookService ;

    public BookController (BookService bookService){
        this.bookService = bookService ;
    }


    @PostMapping ("/create")
    public ResponseEntity <Book> creteBook (@RequestBody Book book){
        Book creteBook = bookService.createBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creteBook);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getOneBook (@PathVariable Long id){
       Book bookRes = bookService.getBook(id);

       if (bookRes == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }
        return ResponseEntity
                .ok()
                .body(bookRes);
    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<Book>> getAllBooks (){

        List<Book> bookList = bookService.getAllBooks();

        if (bookList.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity.ok(bookList) ;

    }

    @PutMapping ("update/{id}")
    public ResponseEntity<Book> updateBook ( @PathVariable Long id ,
                                             @RequestBody Book book){

            Book bookReq = bookService.updateBook (id , book);
            if (bookReq==null){
                ResponseEntity.notFound().build();
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bookReq) ;

    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String >deleteBook (@PathVariable Long id){
        boolean isDeleted = bookService.deleteBook(id);

        if (!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted Successfully") ;
    }


}
