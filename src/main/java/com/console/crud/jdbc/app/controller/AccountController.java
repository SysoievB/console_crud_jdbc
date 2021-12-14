package com.console.crud.jdbc.app.controller;

import com.console.crud.jdbc.app.model.Account;
import com.console.crud.jdbc.app.repository.AccountRepository;
import com.console.crud.jdbc.app.repository.impl.AccountRepositoryImpl;

import java.util.List;

public class AccountController {
    private AccountRepository repository = new AccountRepositoryImpl();

    public List<Account> printAll() {
        return repository.getAll();
    }

    public void saveAccount(Account newAccount) {
        repository.save(newAccount);
    }

    public void deleteAccount(Long index) {
        repository.deleteById(index);
    }

    public void updateAccount(Long id, Account updateAccount) {
        repository.update(id, updateAccount);
    }

    public Account getValueByIndex(Long index) {
        return repository.getById(index);
    }
}
