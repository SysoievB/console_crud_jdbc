package com.console.crud.jdbc.app.util.mappers;

import com.console.crud.jdbc.app.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static List<Order> mapToOrders(ResultSet resultSet) {
        List<Order> orders = new ArrayList<>();

        try {
            while (resultSet.next()) {
                orders.stream()
                        .map(order -> {
                            try {
                                order.setId(resultSet.getLong("id"));
                                order.setName(resultSet.getString("name"));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            return order;
                        }).collect(Collectors.toList());
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public static Order mapperOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("id"));
        order.setName(resultSet.getString("name"));
        return order;
    }
}
