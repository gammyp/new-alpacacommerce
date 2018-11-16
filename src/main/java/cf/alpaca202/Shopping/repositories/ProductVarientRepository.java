package cf.alpaca202.Shopping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cf.alpaca202.Shopping.models.ProductVarient;

@Repository
public interface ProductVarientRepository extends JpaRepository<ProductVarient, Long>{
    
    List<ProductVarient> findByProductId(Long productId);

}