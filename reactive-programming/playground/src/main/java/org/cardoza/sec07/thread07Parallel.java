package org.cardoza.sec07;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class thread07Parallel {

    private static final Logger log = LoggerFactory.getLogger(thread07Parallel.class);

    public static void main(String[] args) {

        Flux.range(1, 10)
                .parallel(3)
                .runOn(Schedulers.parallel())
                .map(thread07Parallel::process)
                .sequential()
                .map(i -> i + "a  ")
                .subscribe(Util.subscriber());

        Util.sleepSeconds(3);
    }

    private static int process(int i) {
        log.info("time consuming task {}", i);
        Util.sleepSeconds(1);
        return i * 2;
    }
}
