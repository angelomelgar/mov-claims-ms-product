package pe.com.movistar.movclaimsmsproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.movistar.movclaimsmsproduct.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByProductCode(Long productCode);

}
