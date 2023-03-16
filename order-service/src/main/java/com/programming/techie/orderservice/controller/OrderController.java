package com.programming.techie.orderservice.controller;

import com.programming.techie.orderservice.client.InventoryClient;
import com.programming.techie.orderservice.dto.OrderDto;
import com.programming.techie.orderservice.model.Order;
import com.programming.techie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor

public class OrderController {

    private OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public String placeOrder(@RequestBody OrderDto orderDto){


        //calling the inventory service
            // using the WebClient, FeignClient or RestTemplate we can do this
            // we'll be using FeignClient
                // so we've added the dependency, annotation to main class
                // created an interface called InventoryInterface and configured the api request we want to hit
                // we'll inject this interface and call the api
        boolean allProductsInStock = orderDto.getOrderLineItems().stream().allMatch(item-> inventoryClient.checkStock(item.getSkuCode()));
        if (allProductsInStock){
            Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItems());
            order.setOrderNumber(UUID.randomUUID().toString());
            orderRepository.save(order);
            return "Order Placed Successfully";
        }

        return "Order failed, One of the product you've ordered is not in stock";

    }

}
