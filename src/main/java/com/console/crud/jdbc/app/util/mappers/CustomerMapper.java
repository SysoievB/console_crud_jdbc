package com.console.crud.jdbc.app.util.mappers;

import com.console.crud.jdbc.app.model.Account;
import com.console.crud.jdbc.app.model.Customer;
import com.console.crud.jdbc.app.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static List<Customer> mapToCustomer(ResultSet resultSet) throws SQLException {
        List<Customer> customersList = new ArrayList<>();
        while (resultSet.next()) {
            Long customerId = resultSet.getLong("customers.id");
            Long accountId = resultSet.getLong("accounts.id");
            String customerName = resultSet.getString("name");
            String customerSurname = resultSet.getString("surname");
            Long orderId = resultSet.getLong("customer_orders.order_id");

            Account account = new Account();
            account.setId(accountId);

            Order order = new Order();
            order.setId(orderId);

            Customer customer = new Customer();
            customer.setId(customerId);
            customer.setName(customerName);
            customer.setSurname(customerSurname);
            customer.setAccount(account);
            customer.setCustomerOrders(order);
            customersList.add(customer);
        }
        return customersList;
    }

    public static Customer mapperCustomer(ResultSet resultSet) throws SQLException {
        Long customerId = resultSet.getLong("customers.id");
        Long accountId = resultSet.getLong("accounts.id");
        String customer_name = resultSet.getString("name");
        String customer_surname = resultSet.getString("surname");
        Long orderId = resultSet.getLong("customer_orders.order_id");

        Account account = new Account();
        account.setId(accountId);

        Order order = new Order();
        order.setId(orderId);

        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName(customer_name);
        customer.setSurname(customer_surname);
        customer.setAccount(account);
        customer.setCustomerOrders(order);

        return customer;
    }
}
