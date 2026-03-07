package org.cardoza.sec11;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class repeatRetry02Retry {

    private static final Logger log = LoggerFactory.getLogger(repeatRetry02Retry.class);

    public static void main(String[] args) {

//        demo1();

//        demo2();

        demo3();

        Util.sleepSeconds(10);
    }

    private static void demo1(){
        getCountryName()
                .retry(2)
                .subscribe(Util.subscriber());
    }

    private static void demo2(){
        getCountryName()
                .retryWhen(Retry.indefinitely()
                        .doBeforeRetry(rs -> log.info("retrying...")))

                .subscribe(Util.subscriber());
    }

    private static void demo3(){
        getCountryName()
                .retryWhen(
                        Retry.fixedDelay(2, Duration.ofSeconds(2))
                                .filter(ex -> RuntimeException.class.equals(ex.getClass()))
                )

                .subscribe(Util.subscriber());
    }


    private static Mono<String> getCountryName() {

        var atomicInteger = new AtomicInteger(0);

        return Mono.fromSupplier(() -> {
            if(atomicInteger.incrementAndGet() < 3) {
                throw new RuntimeException("Ooops");
            }
            return Util.faker().country().name();
        })
                .doOnError(err -> log.info("ERROR: {}", err.getMessage()))
                .doOnSubscribe(s ->log.info("subscribing"));
    }
}
