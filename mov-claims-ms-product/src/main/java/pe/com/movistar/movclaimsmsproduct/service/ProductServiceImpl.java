package pe.com.movistar.movclaimsmsproduct.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.movistar.movclaimsmsproduct.entity.Product;
import pe.com.movistar.movclaimsmsproduct.repository.ProductRepository;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productCode) {
        return (Product) productRepository.findByProductCode(productCode);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB= getProduct(product.getProductCode());
        if(null==productDB){
            return null;
        }
        productDB.setProductName(product.getProductName());
        productDB.setTechnology(product.getTechnology());
        return productRepository.save(productDB);
    }

    @Override
    public void deleteProduct(Long productCode) {
        Product productDB= getProduct(productCode);
        try{
            productRepository.delete(productDB);
        } catch (Exception e) {
            log.error("Error al borrar producto o producto no encontrado");
            e.printStackTrace();
        }
    }
}
