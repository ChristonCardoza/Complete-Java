package com.orderservice.repositories;

import com.orderservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import com.orderservice.domain.OrderHeader;

import java.util.List;


public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
    List<OrderHeader> findAllByCustomer(Customer customer);
}