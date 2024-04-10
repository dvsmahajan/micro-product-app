package com.dvscorp.productapp.repository;

import com.dvscorp.productapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduct extends JpaRepository<Product, Long> {

}
