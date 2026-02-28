 package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

 public class combining12Then {

    private static final Logger log = LoggerFactory.getLogger(combining12Then.class);


    public static void main(String[] args) {

        var records = List.of("a", "b", "c");

//        saveRecords(records)
//                .subscribe(Util.subscriber());

//        saveRecords(records)
//                .then()
//                .subscribe(Util.subscriber());

        saveRecords(records)
                .then( sendNotification(records))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }

    private static Flux<String> saveRecords(List<String> records){
        return Flux.fromIterable(records)
                .map(r -> "saved " + r)
                .delayElements(Duration.ofMillis(500));
    }

     private static Mono<String> sendNotification(List<String> records){
         return Mono.fromRunnable(() -> log.info("all these {} records saved successfull", records));
     }
}
