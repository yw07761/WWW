package vn.edu.iuh.fit.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.repositories.ProductRepository;

import java.util.Date;

@SpringBootTest
class TestApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    void addProduct() {
        productRepository.save(new Product("CE01","Dien Thoai","Dien Thoai Thong Minh",new Date(), 1000.1));
        productRepository.save(new Product("CE02","Tu Lanh","Dien Thoai Thong Minh",new Date(), 1000.1));
        productRepository.save(new Product("CE03","May Say","Dien Thoai Thong Minh",new Date(), 1000.1));
        productRepository.save(new Product("CE04","Ti vi","Dien Thoai Thong Minh",new Date(), 1000.1));
    }

}
