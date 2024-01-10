package com.kevinraupp.nunessports.DesafioEveryMind.repositories;

import com.kevinraupp.nunessports.DesafioEveryMind.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContainsIgnoreCaseOrderByPrice(String name, Pageable pageable);
    Page<Product> findByNameContainsIgnoreCaseOrderByPriceDesc(String name, Pageable pageable);

    Page<Product> findByCodeContainsIgnoreCase(String code, Pageable pageable);

    Page<Product> findByDescriptionContainsIgnoreCase(String description, Pageable pageable);
}