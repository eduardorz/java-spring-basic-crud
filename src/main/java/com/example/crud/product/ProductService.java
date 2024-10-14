package com.example.crud.product;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
            return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product){
        Optional<Product> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("error", true);
            data.put("message", "ya existe un producto con ese nombre");
            return new ResponseEntity<>(
                data,
                HttpStatus.CONFLICT
            );
        }
        productRepository.save(product);
        data.put("data", product);
        data.put("message", "se guardó con exito");
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
            );
    }
}
