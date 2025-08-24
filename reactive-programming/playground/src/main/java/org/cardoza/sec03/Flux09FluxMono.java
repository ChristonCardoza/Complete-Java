package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Flux09FluxMono {

    public static void main(String[] args) {

        var mono = getUserName(1);
        var flux = Flux.from(mono);

        save(flux);

        Mono.from(flux).subscribe(Util.subscriber("FluxMono"));

    }

    private static Mono<String> getUserName(int userId){

        return switch (userId) {
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Oops"));
        };
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber("MonoFlux"));
    }
}
