package cf.alpaca202.Shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.alpaca202.Shopping.models.ProductVarient;
import cf.alpaca202.Shopping.repository.ProductVarientRepository;

@Service
public class ProductVarientService{

    @Autowired
    private ProductVarientRepository productVarientRepository;

    public List<ProductVarient> getProductVarientByProductId(Long productId){
        return productVarientRepository.findByProductId(productId);
    }

    public ProductVarient getProductVarientById(Long id){
        return productVarientRepository.findById(id).get();
    }
}