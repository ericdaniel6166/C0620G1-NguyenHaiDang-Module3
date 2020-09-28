package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

//Bước 3: Tạo interface CustomerService

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);

}
