package org.cardoza.sec07;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class thread03MultipleSubscribeOn {

    private static final Logger log = LoggerFactory.getLogger(thread03MultipleSubscribeOn.class);

    public static void main(String[] args) {

        var flux = Flux.create(sink -> {
                    for (int i = 1; i < 3; i++) {
                        log.info("generating: {}", i);
                        sink.next(i);
                    }
                    sink.complete();
                }).doOnNext(v -> log.info("value: {}", v))
                .subscribeOn(Schedulers.newParallel("vins"))
                .doFirst(() -> log.info("first1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> log.info("first2"));

        Runnable runnable1 = () -> flux.subscribe(Util.subscriber("sub1"));

        Thread.ofPlatform().start(runnable1);

        Util.sleepSeconds(2);

    }
}
