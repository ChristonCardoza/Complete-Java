package org.cardoza.sec11;

import org.cardoza.common.Util;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class repeatRetry01Repeat {

    public static void main(String[] args) {

//       demo1();

//        demo2();

//        demo3();

        demo4();

        Util.sleepSeconds(10);
    }

    private static void demo1(){
        getCountryName()
                .repeat(3)
                .subscribe(Util.subscriber());
    }

    private static void demo2(){
        getCountryName()
                .repeat()
                .takeUntil(c -> c.equalsIgnoreCase("canada"))
                .subscribe(Util.subscriber());
    }

    private static void demo3(){
        var automicInteger = new AtomicInteger(0);

        getCountryName()
                .repeat(() -> automicInteger.incrementAndGet() < 3)
                .subscribe(Util.subscriber());
    }

    private static void demo4(){
        getCountryName()
                .repeatWhen(flux -> flux.delayElements(Duration.ofSeconds(2)))
                .subscribe(Util.subscriber());
    }


    private static Mono<String> getCountryName() {
        return Mono.fromSupplier(() -> Util.faker().country().name());
    }
}
