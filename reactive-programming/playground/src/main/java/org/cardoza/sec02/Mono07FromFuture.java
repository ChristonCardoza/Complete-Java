package org.cardoza.sec02;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Mono07FromFuture {

    public static final Logger log = LoggerFactory.getLogger(Mono07FromFuture.class);

    public static void main(String[] args) {

        Mono.fromFuture(getName()) //eager
                .subscribe(Util.subscriber("eager"));

        Util.sleepSeconds(1);

        Mono.fromFuture(() -> getName()) //lazy
                .subscribe(Util.subscriber("lazy"));

        Util.sleepSeconds(1);
    }

   public static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> {
            log.info("Generating name");
            return Util.faker().name().firstName();
        });
   }


}
