package org.cardoza.sec07;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class thread01DefaultBehavior {

    private static final Logger log = LoggerFactory.getLogger(thread01DefaultBehavior.class);

    public static void main(String[] args) {

        var flux = Flux.create(sink -> {
            for(int i=1; i<3; i++) {
                log.info("generating: {}", i);
                sink.next(i);
            }
            sink.complete();
        }).doOnNext(v -> log.info("value: {}", v));

//        flux.subscribe(Util.subscriber("sub1"));
//        flux.subscribe(Util.subscriber("sub2"));

        Runnable runnable = () -> flux.subscribe(Util.subscriber("sub1"));

        Thread.ofPlatform().start(runnable);
    }
}
