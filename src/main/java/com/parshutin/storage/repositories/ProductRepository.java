package com.parshutin.storage.repositories;

import com.parshutin.storage.datasets.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByTitleStartsWithIgnoreCase(String name);
}
