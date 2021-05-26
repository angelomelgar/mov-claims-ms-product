package pe.com.movistar.movclaimsmsproduct.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.movistar.movclaimsmsproduct.entity.Product;
import pe.com.movistar.movclaimsmsproduct.service.ProductService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping (value ="/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        List<Product> products = productService.listAllProduct();
        if(products.isEmpty()){
            log.error("No existen productos.");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping(value ="/{productCode}")
    public ResponseEntity<Product> getProduct(@PathVariable("productCode") Long productCode){
        Product product = productService.getProduct(productCode);
        if(null==product){
            log.error("Producto no encontrado");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productCreate = productService.createProduct(product);
        log.info("Producto creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }

    @PutMapping(value="/{productCode}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productCode") Long productCode,@RequestBody Product product){
        product.setProductCode(productCode);
        Product productDB = productService.updateProduct(product);
        if(productDB==null){
            log.error("Producto no encontrado");
            return ResponseEntity.notFound().build();
        }
        log.info("Producto actualizado");
        return ResponseEntity.ok(productDB);

    }

    @DeleteMapping(value="/{productCode}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productCode") Long productCode ){
       try {
           productService.deleteProduct(productCode);
           return ResponseEntity.ok().build();
       }catch (Exception e){
           return ResponseEntity.notFound().build();
       }

    }
}
