package com.bookservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book getBook(String isbn) {
        System.out.println(isbn);
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isPresent()) {
            System.out.println("yes");
            return bookOptional.get();
        } else {
            return null;
        }
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
