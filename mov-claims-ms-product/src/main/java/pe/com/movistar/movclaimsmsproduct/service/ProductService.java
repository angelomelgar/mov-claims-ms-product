package pe.com.movistar.movclaimsmsproduct.service;

import pe.com.movistar.movclaimsmsproduct.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> listAllProduct();
    public Product getProduct(Long productCode);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(Long productCode);


}
