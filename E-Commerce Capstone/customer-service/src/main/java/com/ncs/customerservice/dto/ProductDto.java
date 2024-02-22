package com.ncs.customerservice.dto;

import com.ncs.customerservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    private Integer productId;
    private String productName;

    private Integer quantity;
    private String category;
    private String brand;
    private Integer price;

    public ProductDto(Product product){
        ModelMapper modelMapper = new ModelMapper();
        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        this.productId = productDto.getProductId();
        this.productName = productDto.getProductName();
        this.quantity = productDto.getQuantity();
        this.category = productDto.getCategory();
        this.brand = productDto.getBrand();
        this.price = productDto.getPrice();
    }


}
