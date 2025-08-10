package org.cardoza.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Mono02Subscribe {

    public static final Logger log = LoggerFactory.getLogger(Mono02Subscribe.class);

    public static void main(String[] args) {

        var mono = Mono.just("data");
        mono.subscribe(i -> log.info("received: {}",i),
                err -> log.error("error: {}",err),
                () -> log.info("Completed!"));
    }
}
