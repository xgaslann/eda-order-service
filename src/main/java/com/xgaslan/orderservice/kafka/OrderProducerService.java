package com.xgaslan.orderservice.kafka;

import com.xgaslan.orderservice.dto.Order;
import com.xgaslan.orderservice.dto.OrderEvent;
import com.xgaslan.orderservice.dto.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducerService {

    private final NewTopic orderTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderEvent prepareEvent(Order order){
        return OrderEvent.builder()
                .message("Order status is " + OrderStatus.PENDING + " state")
                .status(OrderStatus.PENDING)
                .order(order)
                .build();
    }

    public void sendMessage(OrderEvent event){
        log.info("Order Event: {} sent to topic {}", event.toString(), orderTopic.name());

        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, orderTopic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
