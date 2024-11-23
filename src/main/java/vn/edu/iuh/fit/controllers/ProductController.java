package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dto.request.ProductCreateRequest;
import vn.edu.iuh.fit.dto.request.ProductUpdateRequest;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.serives.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // List all products
    @GetMapping
    public String listProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "product/list";
    }

    // View a single product by ID
    @GetMapping("/{id}")
    public String viewProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    // Show the create product form
    @GetMapping("/create")
    public String showCreateProductForm(Model model) {
        model.addAttribute("productCreateRequest", new ProductCreateRequest());
        return "product/create";
    }

    // Handle create product form submission
    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductCreateRequest request) {
        productService.createProduct(request);
        return "redirect:/products";
    }

    // Show the update product form
    @GetMapping("/update/{id}")
    public String showUpdateProductForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/update";
    }

    // Handle update product form submission
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") int id, @ModelAttribute ProductUpdateRequest request) {
        productService.updateProduct(id, request);
        return "redirect:/products";
    }

    // Delete a product by ID
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    // Search for products by keyword trả về danh sách sản phẩm có chứa keyword trong mã hoặc tên
    @GetMapping("/search")
    public String searchProduct(@RequestParam("search") String keyword, Model model) {
        // Trim and handle null or empty keyword
        if (keyword == null || keyword.trim().isEmpty()) {
            model.addAttribute("products", productService.getAllProduct());
        } else {
            model.addAttribute("products", productService.searchProduct(keyword));
        }
        return "product/list";
    }
}

