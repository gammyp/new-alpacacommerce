package cf.alpaca202.Shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cf.alpaca202.Shopping.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}