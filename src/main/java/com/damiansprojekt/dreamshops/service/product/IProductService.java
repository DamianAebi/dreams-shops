package com.damiansprojekt.dreamshops.service.product;

import com.damiansprojekt.dreamshops.model.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    void updateProductById(Product product, Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryName);
    Long countProductsMyBrandAndName (String brand, String name);
}
