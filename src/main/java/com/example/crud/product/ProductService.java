package com.example.crud.product;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public List<Product> getProducts(){
            return List.of(
                new Product(
                    2641L,
                    "Computadora LENOVO",
                    2600,
                    LocalDate.of(2024, 1, 19),
                    2
                )
            );
     }
}
