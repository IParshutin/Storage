package com.parshutin.storage.repositories;

import com.parshutin.storage.datasets.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
