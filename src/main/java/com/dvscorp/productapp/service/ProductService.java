package com.dvscorp.productapp.service;

import com.dvscorp.productapp.entity.Product;
import com.dvscorp.productapp.repository.IProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final IProduct iProduct;
    private ObjectMapper objectMapper = new ObjectMapper();

    public ProductService(final IProduct iProduct){
        this.iProduct = iProduct;
    }


    public Product create(Product product) {
        return this.iProduct.save(product);
    }

    public Optional<Product> findById(Long id) {
        return this.iProduct.findById(id);
    }

    public Product updateById(Long id, Product product) throws NoResourceFoundException {
        Optional<Product> optionalProduct = iProduct.findById(id);
        if(optionalProduct.isPresent()){
            product.setId(id);
            return this.iProduct.save(product);
        }else{
           throw new NoResourceFoundException(HttpMethod.PUT, "Product id is not available");
        }
    }

    public void delete(Long id) throws NoResourceFoundException {
        Optional<Product> optionalProduct = iProduct.findById(id);
        if(optionalProduct.isPresent()){
            this.iProduct.delete(optionalProduct.get());
        }else{
            throw new NoResourceFoundException(HttpMethod.PUT, "Product id is not available");
        }
    }

    public List<Product> findAll() {
        return iProduct.findAll();
    }
}
