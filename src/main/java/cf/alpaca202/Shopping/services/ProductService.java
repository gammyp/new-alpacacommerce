package cf.alpaca202.Shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.alpaca202.Shopping.models.Product;
import cf.alpaca202.Shopping.repositories.ProductRepository;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();
    }
}