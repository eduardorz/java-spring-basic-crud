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
    HashMap<String, Object> data;


    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
            return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product){
        Optional<Product> res = productRepository.findProductByName(product.getName());
        data = new HashMap<>();

        if(res.isPresent() && product.getId()==null){
            data.put("error", true);
            data.put("message", "ya existe un producto con ese nombre");
            return new ResponseEntity<>(
                data,
                HttpStatus.CONFLICT
            );
        }
        data.put("message", "se guardó con exito");
        if (product.getId()!=null){
            data.put("message", "se actualizó con exito");
        }
        productRepository.save(product);
        data.put("data", product);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
            );
    }

    public ResponseEntity<Object> deleteProduct(Long id){
        data = new HashMap<>();
        boolean exists = this.productRepository.existsById(id);
        if(!exists){
            data.put("error", true);
            data.put("message", "No existe un producto con ese id");
            return new ResponseEntity<>(
                data,
                HttpStatus.CONFLICT
            );
        }
        productRepository.deleteById(id);
        data.put("message", "producto eliminado");
        return new ResponseEntity<>(
            data,
            HttpStatus.ACCEPTED
        );
    }
}
