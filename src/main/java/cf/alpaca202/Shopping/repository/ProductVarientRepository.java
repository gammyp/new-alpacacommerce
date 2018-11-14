package cf.alpaca202.Shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cf.alpaca202.Shopping.models.ProductVarient;

@Repository
public interface ProductVarientRepository extends JpaRepository<ProductVarient, Long>{

}