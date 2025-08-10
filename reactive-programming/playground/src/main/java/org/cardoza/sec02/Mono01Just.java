package org.cardoza.sec02;

import org.cardoza.sec01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Mono01Just {

    public static final Logger log = LoggerFactory.getLogger(Mono01Just.class);

    public static void main(String[] args) {

        var mono1 = Mono.just("data mono 1");
        log.info("{}", mono1);

        var subscriber2 = new SubscriberImpl();
        var mono2 = Mono.just("data mono 2");
        mono2.subscribe(subscriber2);
        subscriber2.getSubscription().request(1);

        var subscriber3 = new SubscriberImpl();
        var mono3 = Mono.just("data mono 3");
        mono3.subscribe(subscriber3);
        subscriber3.getSubscription().cancel();
        subscriber3.getSubscription().request(1);

        var subscriber4 = new SubscriberImpl();
        var mono4 = Mono.just("data mono 4");
        mono4.subscribe(subscriber4);
        subscriber4.getSubscription().request(1);
        subscriber4.getSubscription().request(1);

    }
}
