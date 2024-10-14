package com.example.crud.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;
    

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }
    
}
