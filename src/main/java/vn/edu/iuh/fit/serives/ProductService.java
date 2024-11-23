package vn.edu.iuh.fit.serives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dto.request.ProductCreateRequest;
import vn.edu.iuh.fit.dto.request.ProductUpdateRequest;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public Product getProductById(int id){
        return productRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Khong tim thay id product"));
    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
    public Product createProduct(ProductCreateRequest request){
        Product product = new Product();
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setRegister_date(request.getRegister_date());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }
    public Product updateProduct(int id, ProductUpdateRequest request){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay id product"));
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setRegister_date(request.getRegister_date());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }
    public List<Product> searchProduct(String keyword){
        return productRepository.findByCodeContainingOrNameContaining(keyword, keyword);
    }

}
