package org.cardoza.sec02;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Mono05FromCallable {

    public static final Logger log = LoggerFactory.getLogger(Mono05FromCallable.class);

    public static void main(String[] args) {
       var list = List.of(1,2,3,4,5);

        Mono.fromCallable(() -> sum(list))
                .subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list){
        log.info("Finding the sum of: {}", list);
        return list.stream().mapToInt(i -> i).sum();
    }
}
