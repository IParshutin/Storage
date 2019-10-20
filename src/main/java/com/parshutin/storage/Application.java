package com.parshutin.storage;

import com.parshutin.storage.datasets.Product;
import com.parshutin.storage.datasets.ProductType;
import com.parshutin.storage.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository){
        return e -> {
            productRepository.save(new Product(
                    "Thinking in Java: Bruce Eckel",
                    ProductType.Book,
                    "10",
                    LocalDate.now().minusDays(10)));
            productRepository.save(new Product(
                    "Steppenwolf: Hermann Hesse",
                    ProductType.Book,
                    "3",
                    LocalDate.now()));
            productRepository.save(new Product(
                    "The Hitchhiker's Guide to the Galaxy:  Douglas Adams",
                    ProductType.Book,
                    "7",
                    LocalDate.now()));

            for (Product product : productRepository.findAll()) {
                log.info(product.toString());
            }
        };
    }
}
