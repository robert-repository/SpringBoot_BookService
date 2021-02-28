package com.bookservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/book/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn){
        Book book = bookService.getBook(isbn);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    @PostMapping(value = "/book")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    @DeleteMapping(value = "/book/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn){
        bookService.deleteBook(isbn);
        return  new ResponseEntity<Book>(HttpStatus.OK);
    }

    @GetMapping(value = "/books")
    public Collection<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

}
