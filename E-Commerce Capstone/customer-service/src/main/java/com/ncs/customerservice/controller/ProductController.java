package com.ncs.customerservice.controller;

import com.ncs.customerservice.dto.DataWithSession;
import com.ncs.customerservice.entity.MySessions;
import com.ncs.customerservice.entity.Product;
import com.ncs.customerservice.service.CustomerService;
import com.ncs.customerservice.service.ProductService;
import com.ncs.customerservice.utility.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

//    @CircuitBreaker(name = "product-lists",fallbackMethod = "getAllAvailableProducts")
    @PostMapping("/product/list")
    public ResponseEntity<Response> getAllProduct(@RequestBody MySessions sessions){

        System.out.println(sessions.getCustomerName());
        System.out.println(sessions.getSessionkey());
        System.out.println("inside controller");

        Response response = new Response();

        if(customerService.validateUser(sessions)){
            response.setStatus("success");

            List<Product> products = productService.getAllProduct();

            response.setData(products);

            return new ResponseEntity<>(response , HttpStatus.OK);

        } else {
            response.setStatus("failure");
            response.setMessage("User not valid");
            return new ResponseEntity<>(response , HttpStatus.OK);
        }

    }

//          public Product getAllAvailableProducts(Exception e){
//
//            Product fallBackProduct = new Product();
//            fallBackProduct.setProductId(0);
//            fallBackProduct.setProductName("loading..");
//            fallBackProduct.setCategory("loading...");
//            fallBackProduct.setDescription("loading..");
//            fallBackProduct.setImage("loading..");
//            fallBackProduct.setPrice(0);
//            fallBackProduct.setQuantity(0);
//            return fallBackProduct;
//
//         }

}
