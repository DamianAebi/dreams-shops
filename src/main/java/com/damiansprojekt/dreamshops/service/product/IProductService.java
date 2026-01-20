package com.damiansprojekt.dreamshops.service.product;

import com.damiansprojekt.dreamshops.model.Product;
import com.damiansprojekt.dreamshops.request.AddProductRequest;
import com.damiansprojekt.dreamshops.request.UpdateProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest request);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProductById(UpdateProductRequest product, Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryName);
    Long countProductsByBrandAndName(String brand, String name);
}
