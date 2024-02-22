package com.ncs.customerservice.controller;

import com.ncs.customerservice.dto.DataWithSession;
import com.ncs.customerservice.entity.Cards;
import com.ncs.customerservice.entity.Cart;
import com.ncs.customerservice.entity.MySessions;
import com.ncs.customerservice.entity.Orders;
import com.ncs.customerservice.repository.CardRepository;
import com.ncs.customerservice.service.CartService;
import com.ncs.customerservice.service.CustomerService;
import com.ncs.customerservice.service.OrderService;
import com.ncs.customerservice.service.ProductService;
import com.ncs.customerservice.utility.Response;
import com.netflix.discovery.converters.Auto;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class CartController {


    @Autowired
    CustomerService customerService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Autowired
    CardRepository cardRepository;

    @PostMapping("cart/add")
    public ResponseEntity<Response> addToCart(@RequestBody DataWithSession<List<Cart>> dataWithSession){

        Response response = new Response();

        if(customerService.validateUser(new MySessions(null, dataWithSession.getCustomerName(), dataWithSession.getSessionkey(),null))){
            response.setStatus("success");
            response.setMessage("saved to cart");

            cartService.addToCart(dataWithSession.getData());

            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        else{
            response.setStatus("failure");
            response.setMessage("error saving to cart");

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @PostMapping("/cart/orders")
    public ResponseEntity<Response> getOrderList(@RequestBody MySessions mySessions){

        Response response = new Response();

        if(customerService.validateUser(mySessions)){
            response.setStatus("success");
            response.setMessage("valid user");

            List<Cart> orderList = cartService.getOrdersList(mySessions.getCustomerName());
            System.out.println(orderList);
            response.setData(orderList);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else {
            response.setStatus("failure");
            response.setMessage("error happened while retrieving ordered items");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

    }

    @PostMapping("/cart/card/add")
    public ResponseEntity<Response> saveCard(@RequestBody DataWithSession<Cards> dataWithSession) throws NoSuchAlgorithmException {

        System.out.println(dataWithSession);

        Response response = new Response();
        if(customerService.validateUser(new MySessions(null,dataWithSession.getCustomerName(), dataWithSession.getSessionkey(),null))){

            response.setStatus("success");
            response.setMessage("Valid user going to save card details");
            System.out.println(dataWithSession.getData());
            cartService.savecard(dataWithSession.getData());
            return new ResponseEntity<>(response,HttpStatus.OK);

        }
        else{
            response.setStatus("failure");
            response.setMessage("Invalid user");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

    }

    @PostMapping("/cart/cards/all")
    public ResponseEntity<Response> getAllCards(@RequestBody MySessions mySessions){

        Response response = new Response();
        if(customerService.validateUser(mySessions)){

            response.setStatus("success");
            response.setMessage("Valid user getting all saved cards");

            List<Cards> cardsList = cardRepository.findAllByUsername(mySessions.getCustomerName());
            System.out.println(cardsList);
            response.setData(cardsList);

            return new ResponseEntity<>(response,HttpStatus.OK);

        }
        else{
            response.setStatus("failure");
            response.setMessage("Invalid user");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

    }
    @PostMapping("order/save")
    public ResponseEntity<Response> saveorder(@RequestBody DataWithSession<Orders> dataWithSession){
        System.out.println("ORDER DATA");
        System.out.println(dataWithSession);
        Response response = new Response();

        if(customerService.validateUser( new MySessions( null, dataWithSession.getCustomerName() , dataWithSession.getSessionkey(), null ))){
            response.setStatus("success");

            orderService.saveorder(dataWithSession.getData());

            return new ResponseEntity<>(response , HttpStatus.OK);
        } else {
            response.setStatus("failure, user not valid in saveorder()");
            return new ResponseEntity<>(response , HttpStatus.OK);
        }
    }




}
