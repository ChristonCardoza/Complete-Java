package org.cardoza.sec09.application;

import reactor.core.publisher.Mono;

import java.util.Map;

public class PaymentService {

    private static final Map<Integer, Integer> userBalancetable = Map.of(
            1, 100,
            2, 200,
            3, 300
    );

    public static Mono<Integer> getUserBalance(Integer userId){
        return Mono.fromSupplier(() -> userBalancetable.get(userId));
    }
}
