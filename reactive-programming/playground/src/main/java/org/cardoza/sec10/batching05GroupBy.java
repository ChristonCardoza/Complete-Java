package org.cardoza.sec10;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class batching05GroupBy {

    private static final Logger log = LoggerFactory.getLogger(batching05GroupBy.class);

    public static void main(String[] args) {

        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2) // 0 1
                .flatMap(batching05GroupBy::processEvents)
                .subscribe();

        Util.sleepSeconds(20);


    }

    private static Mono<Void> processEvents(GroupedFlux<Integer, Integer> groupedFlux){
        log.info("received flux for {}", groupedFlux.key());
        return groupedFlux.doOnNext(i -> log.info("key: {}, item: {}", groupedFlux.key(), i))
                .doOnComplete(() -> log.info("{} completed", groupedFlux.key()))
                .then();
    }

}