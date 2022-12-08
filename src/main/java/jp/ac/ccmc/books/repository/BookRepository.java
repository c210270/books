package jp.ac.ccmc.books.repository;

import jp.ac.ccmc.books.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByBookIdOrBookNameOrPriceOrAuthor(Long bookId,String bookName,Integer price,String author);
}
