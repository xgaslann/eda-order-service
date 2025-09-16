package com.xgaslan.orderservice.constants;

public final class KafkaConstants {
    public static final String BOOTSTRAP_SERVERS = "localhost:9092";

    public static final String TOPIC_NAME = "order_topics";

    public static final Integer PARTITION_COUNT = 3;

    public static final Integer REPLICA_COUNT = 1;
}
