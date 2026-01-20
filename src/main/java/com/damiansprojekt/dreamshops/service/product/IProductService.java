package com.damiansprojekt.dreamshops.service.product;

import com.damiansprojekt.dreamshops.model.Product;
import com.damiansprojekt.dreamshops.request.AddProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest request);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    void updateProductById(Product product, Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryName);
    Long countProductsByBrandAndName(String brand, String name);
}
