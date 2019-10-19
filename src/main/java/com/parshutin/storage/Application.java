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
                    "Some Book 1",
                    ProductType.Book,
                    10,
                    LocalDate.now()));
            productRepository.save(new Product(
                    "Some Journal 1",
                    ProductType.Journal,
                    5,
                    LocalDate.now()));

            for (Product product : productRepository.findAll()) {
                log.info(product.toString());
            }
        };
    }
}
