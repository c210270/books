package jp.ac.ccmc.books.initData;


import jp.ac.ccmc.books.entity.Book;
import jp.ac.ccmc.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Component
@RequiredArgsConstructor
public class Configuration {
    private BookRepository bookRepository;

//    public void initData() {
//        bookRepository.saveAll(IntStream.range(1, 21)
//                .mapToObj(i -> Book.builder()
//                        .bookName("sach" + i)
//                        .price(200 + i)
//                        .author("author" + i)
//                        .build())
//                .collect(Collectors.toList()));
//    }
}
