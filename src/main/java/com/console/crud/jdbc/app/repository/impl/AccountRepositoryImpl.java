package com.console.crud.jdbc.app.repository.impl;

import com.console.crud.jdbc.app.model.Account;
import com.console.crud.jdbc.app.repository.AccountRepository;
import com.console.crud.jdbc.app.util.ConnectionConfig;
import com.console.crud.jdbc.app.util.mappers.AccountMapper;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public Account save(Account account) {
        try (Connection connection = ConnectionConfig.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accounts (id,status)" +
                    "VALUES (?,?)")) {
                preparedStatement.setLong(1, account.getId());
                preparedStatement.setString(2, account.getStatus().name());
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = null;
        try (Connection connection = ConnectionConfig.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
            accounts = AccountMapper.mapToAccounts(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account getById(Long id) {
        Account account = new Account();
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account = AccountMapper.mapperAccount(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (account == null) {
            Optional<Account> empty = Optional.empty();
            return empty.orElseThrow(NullPointerException::new);
        } else return account;
    }

    @Override
    public void update(Long id, Account account) {
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE accounts SET " +
                     "status = ? WHERE id = ?")) {
            preparedStatement.setString(1, account.getStatus().name());
            preparedStatement.setLong(2, account.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM accounts WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
