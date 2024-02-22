package com.ncs.customerservice.service;

import com.ncs.customerservice.dto.ProductDto;
import com.ncs.customerservice.entity.MySessions;
import com.ncs.customerservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    Product addNewProduct(ProductDto productDto);

    List<Product> getAllProduct();
    ResponseEntity<String> updateProductByQuantity(Integer productId, Integer quantity);

    Product getProductById(Integer id);

    List<Product> findProductsWithSorting(String field);

    Page<Product> findProductsWithPagination(int offset, int pageSize);
}
