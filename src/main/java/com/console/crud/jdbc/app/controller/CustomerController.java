package com.console.crud.jdbc.app.controller;

import com.console.crud.jdbc.app.model.Account;
import com.console.crud.jdbc.app.model.Customer;
import com.console.crud.jdbc.app.repository.AccountRepository;
import com.console.crud.jdbc.app.repository.CustomerRepository;
import com.console.crud.jdbc.app.repository.impl.AccountRepositoryImpl;
import com.console.crud.jdbc.app.repository.impl.CustomerRepositoryImpl;

import java.util.List;

public class CustomerController {
    private CustomerRepository repository = new CustomerRepositoryImpl();

    public List<Customer> printAll() {
        return repository.getAll();
    }

    public void saveCustomer(Customer newCustomer) {
        repository.save(newCustomer);
    }

    public void deleteCustomer(Long index) {
        repository.deleteById(index);
    }

    public void updateCustomer(Long id, Customer updateCustomer) {
        repository.update(id, updateCustomer);
    }

    public Customer getValueByIndex(Long index) {
        return repository.getById(index);
    }
}
