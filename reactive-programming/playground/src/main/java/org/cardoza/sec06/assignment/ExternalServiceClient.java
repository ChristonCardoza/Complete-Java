package org.cardoza.sec06.assignment;

import org.cardoza.common.AbstractHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Objects;


public class ExternalServiceClient extends AbstractHttpClient {

    private static final Logger log = LoggerFactory.getLogger(ExternalServiceClient.class);

    private Flux<Order> orderFlux;

    public Flux<Order> orderStream() {
        if(Objects.isNull(orderFlux)){
            this.orderFlux = getOrderStream();
        }
        return this.orderFlux;
    }

    private Flux<Order> getOrderStream() {
        return this.httpClient.get()
                .uri("/demo04/order/stream")
                .responseContent()
                .asString()
                .map(this::parse)
                .doOnNext(o-> log.info("{}"))
                .publish()
                .refCount();
    }

    private Order parse(String message){
        var arr = message.split(":");
        return new Order(
                arr[1],
            Integer.parseInt(arr[2]),
            Integer.parseInt(arr[3])
        );
    }
}
