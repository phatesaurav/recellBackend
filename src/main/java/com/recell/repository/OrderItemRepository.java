package com.recell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recell.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}