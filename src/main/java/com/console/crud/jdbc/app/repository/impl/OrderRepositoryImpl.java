package com.console.crud.jdbc.app.repository.impl;

import com.console.crud.jdbc.app.model.Order;
import com.console.crud.jdbc.app.repository.OrderRepository;
import com.console.crud.jdbc.app.util.ConnectionConfig;
import com.console.crud.jdbc.app.util.mappers.OrderMapper;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public Order save(Order order) {
        try (Connection connection = ConnectionConfig.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (id,order_name)" +
                    "VALUES (?,?)")) {
                preparedStatement.setLong(1, order.getId());
                preparedStatement.setString(2, order.getName());
                preparedStatement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = null;
        try (Connection connection = ConnectionConfig.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
            orders = OrderMapper.mapToOrders(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getById(Long id) {
        Order order = new Order();
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order = OrderMapper.mapperOrder(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (order == null) {
            Optional<Order> empty = Optional.empty();
            return empty.orElseThrow(NullPointerException::new);
        } else return order;
    }

    @Override
    public void update(Long id, Order order) {
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders SET " +
                     "order_name = ? WHERE id = ?")) {
            preparedStatement.setString(1, order.getName());
            preparedStatement.setLong(2, order.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
