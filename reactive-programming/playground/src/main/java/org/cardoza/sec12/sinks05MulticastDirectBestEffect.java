package org.cardoza.sec12;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class sinks05MulticastDirectBestEffect {

    private static final Logger log = LoggerFactory.getLogger(sinks05MulticastDirectBestEffect.class);


    public static void main(String[] args) {

//        demo1();

//        demo2();

        demo3();

        Util.sleepSeconds(20);
    }


    private static void demo1(){

        System.setProperty("reactor.bufferSize.small", "16");

        var sink = Sinks.many().multicast().onBackpressureBuffer();

        var flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));

        flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("mike"));

       for(int i= 1; i <= 100; i++){
           var result = sink.tryEmitNext(i);
           log.info("item: {}, result: {}", i, result);
       }
    }

    private static void demo2(){

        System.setProperty("reactor.bufferSize.small", "16");

        var sink = Sinks.many().multicast().directBestEffort();

        var flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));

        flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("mike"));

        for(int i= 1; i <= 100; i++){
            var result = sink.tryEmitNext(i);
            log.info("item: {}, result: {}", i, result);
        }
    }

    private static void demo3(){

        System.setProperty("reactor.bufferSize.small", "16");

        var sink = Sinks.many().multicast().directBestEffort();

        var flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));

        flux.onBackpressureBuffer().delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("mike"));

        for(int i= 1; i <= 100; i++){
            var result = sink.tryEmitNext(i);
            log.info("item: {}, result: {}", i, result);
        }
    }
}
