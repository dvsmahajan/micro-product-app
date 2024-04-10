package com.dvscorp.productapp.resource;

import com.dvscorp.productapp.entity.Product;
import com.dvscorp.productapp.service.ProductService;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductResource {

    private final ProductService productService;


    public ProductResource(final ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id) throws NoResourceFoundException {
        Optional<Product> optionalProduct = this.productService.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new NoResourceFoundException(HttpMethod.GET,"Product is not available" );
    }


    @PostMapping
    public Product create(@RequestBody Product product){
        return this.productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable(name = "id") Long id, @RequestBody Product product) throws NoResourceFoundException {
        return this.productService.updateById(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) throws NoResourceFoundException {
        this.productService.delete(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }
}
