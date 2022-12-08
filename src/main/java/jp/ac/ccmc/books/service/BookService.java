package jp.ac.ccmc.books.service;

import jp.ac.ccmc.books.entity.Book;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;


public interface BookService {
    Book createBook(Book book);

    Book getBookById(Long bookId);

    boolean deleteBook(Long bookId);

    Book updateBook(Long bookId,Book book);

    List<Book> getAllBook();

    Page<Book> getPageCustom(Integer i,Pageable pageable);

    List<Book> getByIdPriceAuthor(Long bookId,String bookName,Integer price,String author);

}
