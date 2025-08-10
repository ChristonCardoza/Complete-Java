package org.cardoza.sec02;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Mono08Defer {

    public static final Logger log = LoggerFactory.getLogger(Mono08Defer.class);

    public static void main(String[] args) {
       Mono.defer(() -> createPublisher())
               .subscribe(Util.subscriber("Defer"));
    }

    private static Mono<Integer> createPublisher(){
        log.info("Create Publisher");
        var list = List.of(1,2,3,4,5);

        Util.sleepSeconds(1);

        return Mono.fromSupplier(() -> sum(list));

    }

    private static int sum(List<Integer> list){
        log.info("Finding the sum of: {}", list);
        return list.stream().mapToInt(i -> i).sum();
    }
}
