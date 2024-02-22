package com.ncs.customerservice.service;

import com.ncs.customerservice.Exceptions.CustomerNotFoundException;
import com.ncs.customerservice.dto.CustomerDto;
import com.ncs.customerservice.entity.Customer;
import com.ncs.customerservice.entity.MySessions;
import com.ncs.customerservice.repository.CustomerRepository;
import com.ncs.customerservice.repository.SessionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SessionRepository sessionRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public Boolean addCustomer(CustomerDto customerDto) throws NoSuchAlgorithmException {

        Customer newCustomer = modelMapper.map(customerDto,Customer.class);
        List<Customer> customerList = customerRepository.findAllByEmail(customerDto.getEmail());
        List<Customer> allCustomers = customerRepository.findAllByCustomerName(customerDto.getCustomerName());

            if (allCustomers.isEmpty() && customerList.isEmpty()) {

                MessageDigest messageDigest = MessageDigest.getInstance("MD5");

                messageDigest.update(customerDto.getPassword().getBytes());

                byte[] resultByteArray = messageDigest.digest();

                StringBuilder sb = new StringBuilder();

                for (byte b : resultByteArray) {
                    sb.append(String.format("%02x", b));
                }

                newCustomer.setPassword(sb.toString());

                customerRepository.save(newCustomer);
                return true;
            } else {
                return false;
            }
        }


    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return allCustomers;
    }

    @Override
    public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException{
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        Customer customer = optionalCustomer.get();
        return customer;
    }

    @Override
    public Boolean welcome(CustomerDto customerDto) throws NoSuchAlgorithmException {
        Customer newCustomer = modelMapper.map(customerDto,Customer.class);
        System.out.println(newCustomer);

        List<Customer> allCustomers = customerRepository.findAllByEmail(newCustomer.getEmail());
        System.out.println(allCustomers);

        if(allCustomers.isEmpty()){

            return false;
        }
        else{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(newCustomer.getPassword().getBytes());

            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            String hashedPassword = sb.toString();

            if(allCustomers.get(0).getPassword().equals(hashedPassword)){
                return true;
            }
            else
                return false;
        }
    }

    @Override
    public boolean validateUser(MySessions sessions) {

        List<Customer> allCustomers = customerRepository.findAllByCustomerName(sessions.getCustomerName());
        if(allCustomers.isEmpty())
            return false;
        else
            return true;
    }

    @Override
    public boolean logout(MySessions mySessions) {
        System.out.println("INSIDE LOGOUT IN CUSTOMER SEVICE");
        System.out.println(mySessions);

        List<MySessions> sessionsList = sessionRepository.findAllByCustomerName(mySessions.getCustomerName());
        System.out.println(sessionsList);
        int length = sessionsList.size();
        System.out.println(length);

        if(sessionsList.isEmpty()){
            System.out.println("\n SESSION LIST IS EMPTY");
            return false;
        }
        else{
            System.out.println("SESSION LIST>GET()"+sessionsList.get(length-1));
            System.out.println("FROM DB "+sessionsList.get(0).getSessionkey());
            System.out.println("FROM MY SESSIONS "+mySessions.getSessionkey());
            boolean counter = true;
            for(int i=0;i<length;i++){
                if(sessionsList.get(i).getSessionkey().equals((mySessions.getSessionkey()))){

                    sessionRepository.delete(sessionsList.get(i));

                }
            }
            if(counter){
                System.out.println("SESSIONS FOUND");
                return true;
            }
            else{
                return false;
            }
          }


    }
}
