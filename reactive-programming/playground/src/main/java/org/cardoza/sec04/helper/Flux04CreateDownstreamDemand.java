package org.cardoza.sec04.helper;


import org.cardoza.common.Util;
import org.cardoza.sec01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Flux04CreateDownstreamDemand {

    private static Logger logger = LoggerFactory.getLogger(Flux04CreateDownstreamDemand.class);

    public static void main(String[] args) {
//        produceEarly();

        produceOnDemand();
    }

    private static void produceEarly() {

        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            for(int i=0; i<10; i++){
                var name = Util.faker().name().firstName();
                logger.info("Generated: " + name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);

        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
    }

    private static void produceOnDemand() {

        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            fluxSink.onRequest(request -> {
                for(int i=0; i<request; i++){
                    var name = Util.faker().name().firstName();
                    logger.info("Generated: " + name);
                    fluxSink.next(name);
                }
            });
        }).subscribe(subscriber);

        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
    }
}
