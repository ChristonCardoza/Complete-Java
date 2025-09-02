package org.cardoza.sec05;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Operator06Timeout {

    private static final Logger log = LoggerFactory.getLogger(Operator06Timeout.class);

    public static void main(String[] args) {
        var mono = getProductName()
                .timeout(Duration.ofMillis(1), fallback());

        mono
                .timeout(Duration.ofMillis(5000))
                .subscribe(Util.subscriber("timeout"));

        Util.sleepSeconds(5);
    }

    private static Mono<String> getProductName(){
        return Mono.fromSupplier(() -> "service-" + Util.faker().commerce().productName()).delayElement(Duration.ofMillis(1900));
    }

    private static Mono<String> fallback() {
        return Mono.fromSupplier(() -> "fallback-" + Util.faker().commerce().productName())
                .delayElement(Duration.ofMillis(300))
                .doFirst(() -> log.info("do first"));
    }
}
