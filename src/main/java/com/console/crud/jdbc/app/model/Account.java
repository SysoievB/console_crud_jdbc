package com.console.crud.jdbc.app.model;

public class Account {
    private Long id;
    private AccountStatus status;

    public Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    public Account(Long id, AccountStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " " + status.toString();
    }
}
