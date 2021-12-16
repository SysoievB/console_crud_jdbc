package com.console.crud.jdbc.app.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Customer {
    private Long id;
    private String name;
    private String surname;
    private Account account;
    private Set<Order> orders = new HashSet<>();

    public Customer() {
    }

    public Customer(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Customer(Long id, String name, String surname, Account account, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setCustomerOrders(Order customerOrder) {
        this.orders.add(customerOrder);
    }

    public Set<Long> toLongSet() {
        return orders
                .stream()
                .map(Order::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + account.getId() + " " + toLongSet();
    }
}
