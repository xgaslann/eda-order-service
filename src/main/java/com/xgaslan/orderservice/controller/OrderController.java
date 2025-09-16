package com.xgaslan.orderservice.controller;

import com.xgaslan.orderservice.dto.Order;
import com.xgaslan.orderservice.dto.OrderEvent;
import com.xgaslan.orderservice.kafka.OrderProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducerService orderProducerService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        OrderEvent event = orderProducerService.prepareEvent(order);
        orderProducerService.sendMessage(event);
        return ResponseEntity.ok("Order Placed Successfully");
    }
}
