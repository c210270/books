package jp.ac.ccmc.books.service.imp;

import jp.ac.ccmc.books.entity.Book;
import jp.ac.ccmc.books.repository.BookRepository;
import jp.ac.ccmc.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;


@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("khong tim thay id sach" + bookId));
        return book;
    }

    @Override
    public boolean deleteBook(Long bookId) {
         bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("khong tim thay id sach" + bookId));
         bookRepository.deleteById(bookId);
        return true;
    }

    @Override
    public Book updateBook(Long bookId, Book newBook) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("khong tim thay id sach" + bookId));
        book.setBookName(newBook.getBookName());
        book.setPrice(newBook.getPrice());
        book.setAuthor(newBook.getAuthor());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getPageCustom(Integer i,Pageable pageable) {
         Page<Book> page =  bookRepository.findAll(PageRequest.of(0+i,5));
         return page;
    }

    @Override
    public List<Book> getByIdPriceAuthor(Long bookId, String bookName,Integer price, String author) {
        return bookRepository.findByBookIdOrBookNameOrPriceOrAuthor(bookId,bookName,price,author);
    }


}
