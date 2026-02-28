package org.cardoza.sec08;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class backpressure05Stratergies {

    private static final Logger log = LoggerFactory.getLogger(backpressure05Stratergies.class);

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
//                .onBackpressureBuffer()
//                .onBackpressureError()
//                .onBackpressureBuffer(10) // 2 - 11 stored
//                .onBackpressureDrop().log() // after 16 its drops, again buffer empty 75%, again request for 16 rest drops
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .map(backpressure05Stratergies::timeConsumingTask)
                .subscribe();

        Util.sleepSeconds(60);

    }

    private static int timeConsumingTask(int i) {
        log.info("recieved: {}",i);
        Util.sleepSeconds(1);
        return i;
    }
}
