package org.cardoza.sec02;

import org.cardoza.common.Util;
import reactor.core.publisher.Mono;

public class Mono3EmptyError {

    public static void main(String[] args) {

        getUsername(1).subscribe(Util.subscriber("1"));

        getUsername(2).subscribe(Util.subscriber("2"));

        getUsername(3).subscribe(Util.subscriber("3"));
    }

    public static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("Cardoza");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid userId"));
        };
    }
}
