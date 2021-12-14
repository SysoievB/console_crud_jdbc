package com.console.crud.jdbc.app.util.mappers;

import com.console.crud.jdbc.app.model.Account;
import com.console.crud.jdbc.app.model.AccountStatus;
import com.console.crud.jdbc.app.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountMapper {

    public static List<Account> mapToAccounts(ResultSet resultSet) {
        List<Account> accounts = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setStatus(AccountStatus.valueOf(resultSet.getString("status")));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static Account mapperAccount(ResultSet resultSet) {
        Account account = new Account();
        try {
            account.setId(resultSet.getLong("id"));
            account.setStatus(AccountStatus.valueOf(resultSet.getString("status")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
