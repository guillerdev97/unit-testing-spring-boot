package com.guillerdev97.testing.repository;

import com.github.javafaker.Faker;
import com.guillerdev97.testing.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ComponentScan(basePackages = "com.guillerdev97.*")
@EntityScan("com.guillerdev97.*")
@EnableJpaRepositories(basePackages = "com.guillerdev97.repository")
public class DataLoader implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final Faker faker;

    public DataLoader(BookRepository bookRepository, Faker faker) {
        this.bookRepository = bookRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        List<Book> book = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> new Book(
                        faker.name().name(),
                        faker.name().name(),
                        faker.number().numberBetween(1, 5)
                )).collect(Collectors.toList());

        bookRepository.saveAll(book);
    }
}
