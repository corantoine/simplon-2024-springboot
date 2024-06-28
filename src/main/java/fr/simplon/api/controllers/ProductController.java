package fr.simplon.api.controllers;

import fr.simplon.api.models.Product;
import fr.simplon.api.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

private final ProductRepository productRepository;

    public ProductController(ProductRepository newProductRepository) {
        this.productRepository = newProductRepository;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable int productId) {
    productRepository.findById(productId);
    productRepository.deleteById(productId);
    }




}
