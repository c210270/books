package jp.ac.ccmc.books.controller;


import jp.ac.ccmc.books.entity.Book;
import jp.ac.ccmc.books.repository.BookRepository;
import jp.ac.ccmc.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;


    //api get all book
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    //api get book by id
    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId){
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }


    // api delete book by id
    @DeleteMapping("/book/{ibookId}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long bookId){
        return ResponseEntity.ok(bookService.deleteBook(bookId));
    }

    //api update book by id
    @PutMapping("/book")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id,@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }

    //api create book
    @PostMapping("book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping("/book/page/{i}")
    public Page<Book> listCustomers(@PathVariable Integer i, Pageable pageable){
        return bookService.getPageCustom(i,pageable);
    }

    @GetMapping("/book/find")
    public ResponseEntity<List<Book>> findByIdPriceAuthor(@RequestParam Long bookId,@RequestParam String bookName,@RequestParam Integer price,@RequestParam String author){
        List<Book> findBook= bookService.getByIdPriceAuthor(bookId,bookName,price,author);
         return ResponseEntity.ok(findBook);
    }
}
