package org.cardoza.sec08;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class backpressure04FluxCreate {

    private static final Logger log = LoggerFactory.getLogger(backpressure04FluxCreate.class);

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        var producer = Flux.create(
                 sink -> {
                     for(int i=1; i<=500 && !sink.isCancelled(); i++) {
                         log.info("generating {}", i);
                         sink.next(i);
                         Util.sleep(Duration.ofMillis(50));
                     }
                }
        ).cast(Integer.class)
                .subscribeOn(Schedulers.parallel());

        producer
                .publishOn(Schedulers.boundedElastic())
                .map(backpressure04FluxCreate::timeConsumingTask)
                .subscribe();

        Util.sleepSeconds(60);

    }

    private static int timeConsumingTask(int i) {
        log.info("recieved: {}",i);
        Util.sleepSeconds(1);
        return i;
    }
}
