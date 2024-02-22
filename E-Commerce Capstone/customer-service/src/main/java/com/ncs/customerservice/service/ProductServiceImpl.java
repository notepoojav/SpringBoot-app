package com.ncs.customerservice.service;

import com.ncs.customerservice.Exceptions.ProductExceptionClass;
import com.ncs.customerservice.dto.ProductDto;
import com.ncs.customerservice.entity.MySessions;
import com.ncs.customerservice.entity.Product;
import com.ncs.customerservice.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public Product addNewProduct(ProductDto productDto) {

        Product newProduct = modelMapper.map(productDto,Product.class);
        newProduct.setProductId(productDto.getProductId());
        newProduct.setProductName(productDto.getProductName());
//        newProduct.setBrand(productDto.getBrand());
        newProduct.setCategory(productDto.getCategory());
        newProduct.setPrice(productDto.getPrice());

        return productRepository.save(newProduct);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<String> updateProductByQuantity(Integer productId, Integer quantity) throws ProductExceptionClass{
        int pid= productId;
        int qty = quantity;

        if(qty < 1){
            throw new ProductExceptionClass("Must update quantity with minimum amount = 1");
        }

        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product updateProduct = optionalProduct.get();

        int updateQuantity = updateProduct.getQuantity() + qty;
        updateProduct.setQuantity(updateQuantity);
        productRepository.save(updateProduct);
        System.out.println("Updated Product :"+updateProduct);

        return new ResponseEntity<>("Successfully updated product",HttpStatus.OK);
    }

    @Override
    public Product getProductById(Integer id) throws ProductExceptionClass {
        int findById = id;
        Optional<Product> optionalProduct = productRepository.findById(findById);
        if(!optionalProduct.isPresent()){
            throw new ProductExceptionClass("Sorry, product is unavailable for the moment");
        }
        Product findProduct = optionalProduct.get();

        return findProduct;
    }

    @Override
    public List<Product> findProductsWithSorting(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    @Override
    public Page<Product> findProductsWithPagination(int offset, int pageSize) {
        Page<Product> productPage = productRepository.findAll(PageRequest.of(offset,pageSize));
        return productPage;
    }

}
