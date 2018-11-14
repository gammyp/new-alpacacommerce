package cf.alpaca202.Shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.alpaca202.Shopping.models.Product;
import cf.alpaca202.Shopping.repository.ProductRepository;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}