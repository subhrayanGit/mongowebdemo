package com.product.mongowebdemo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.mongowebdemo.model.Product;
import com.product.mongowebdemo.repo.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> listProducts(Product product) {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product viewProduct(@PathVariable String id, Product product) {
        return productRepository.findById(id).orElse(null);
    }

	/*
	 * @GetMapping("/create") public String createProductForm(Model model) {
	 * model.addAttribute("product", new Product()); return "product/create"; }
	 */

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

	/*
	 * @GetMapping("/update/{id}") public String updateProductForm(@PathVariable
	 * String id, Model model) { model.addAttribute("product",
	 * productRepository.findById(id).orElse(null)); return "product/update"; }
	 */

    @PostMapping("/update/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public List<Product> deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
    
}
