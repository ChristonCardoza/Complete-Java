package org.cardoza.sec04;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux01 {

    public static void main(String[] args) {

        Flux.create( fluxSink -> {
            String country;

            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while (!country.equalsIgnoreCase("canada"));

            fluxSink.complete();
        }).subscribe(Util.subscriber("Flux-Create"));
    }
}
