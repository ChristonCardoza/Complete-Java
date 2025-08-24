package org.cardoza.sec04;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

 public class Flux05Generate {

    private static final Logger log = LoggerFactory.getLogger(Flux05Generate.class);

    public static void main(String[] args) {


        Flux.generate(synchronousSink -> {
            log.info("invoked");
            synchronousSink.next(1);
        })
                .take(4)
                .subscribe(Util.subscriber());
    }
}
