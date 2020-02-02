package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nAuthor with all books ...");
            bookstoreService.fetchAuthorWithAllBooks();

            System.out.println("\nAuthor with cheap books ...");
            bookstoreService.fetchAuthorWithCheapBooks();

            System.out.println("\nAuthor with rest of books ...");
            bookstoreService.fetchAuthorWithRestOfBooks();
        };
    }
}

/*
 * Filter Association Via Hibernate @Where

Note: Rely on this approach only if you simply cannot use JOIN FETCH WHERE or @NamedEntityGraph.

Description: This application is a sample of using Hibernate @Where for filtering associations.

Key points:

use @Where(clause = "condition to be met") in entity (check the Author entity)
 */
