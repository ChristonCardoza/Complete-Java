package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.cardoza.sec09.application.OrderService;
import org.cardoza.sec09.application.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class combining11CollectList {

    private static final Logger log = LoggerFactory.getLogger(combining11CollectList.class);


    public static void main(String[] args) {

        Flux.range(1, 10)
                        .collectList()
                                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }
}
