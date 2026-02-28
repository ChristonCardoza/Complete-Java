package org.cardoza.sec06;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class pub01ColdPub {

    private static final Logger log = LoggerFactory.getLogger(pub01ColdPub.class);

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        var flux = Flux.create( fluxSink -> {
            log.info("Invoked");

            for(int i=0; i<3; i++){
                fluxSink.next(atomicInteger.incrementAndGet());
            }

            fluxSink.complete();
        });

        flux.subscribe(Util.subscriber("Subscribe - 1"));

        flux.subscribe(Util.subscriber("Subscribe - 2"));
    }
}
