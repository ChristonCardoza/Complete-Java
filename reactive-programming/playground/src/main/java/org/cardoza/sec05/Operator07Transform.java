package org.cardoza.sec05;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Operator07Transform {

    private static final Logger log = LoggerFactory.getLogger(Operator07Transform.class);

    record Customer(int id, String name){}

    record PurchaseOrder(String productName, int price, int quantity){}

    public static void main(String[] args) {

        var isDebugEnable = false;

        getCustomer()
                .transform( isDebugEnable ? addDebugger() : Function.identity())
                .subscribe();

        getPurchaseOrders()
                .transform(addDebugger())
                .subscribe();
    }

    private static Flux<Customer> getCustomer(){
        return Flux.range(1,3)
                .map(i -> new Customer(i, Util.faker().name().firstName()));
    }

    private static Flux<PurchaseOrder> getPurchaseOrders(){
        return Flux.range(1,5)
                .map(i -> new PurchaseOrder(Util.faker().commerce().productName(), i, i*10));
    }

    private static <T>UnaryOperator<Flux<T>> addDebugger(){
        return flux -> flux
                .doOnNext(i -> log.info("received: {}", i))
                .doOnComplete(() -> log.info("completed"))
                .doOnError(err -> log.error("error: ", err));
    }

}
