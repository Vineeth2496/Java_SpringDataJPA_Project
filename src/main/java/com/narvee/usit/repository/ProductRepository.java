package com.narvee.usit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narvee.usit.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
