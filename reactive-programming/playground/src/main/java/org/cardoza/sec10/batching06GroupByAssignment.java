package org.cardoza.sec10;

import org.cardoza.common.Util;
import org.cardoza.sec10.assignment.groupBy.OrderProcessingService;
import org.cardoza.sec10.assignment.groupBy.PurchaseOrder;
import org.cardoza.sec10.assignment.window.FileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class batching06GroupByAssignment {

    private static final Logger log = LoggerFactory.getLogger(batching06GroupByAssignment.class);

    public static void main(String[] args) {

        orderStream()
                .filter(OrderProcessingService.canProcess())
                .groupBy(PurchaseOrder::category)
                .flatMap(gf -> gf.transform(OrderProcessingService.getProcessor(gf.key())))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);

    }

    private static Flux<PurchaseOrder> orderStream(){
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> PurchaseOrder.create());
    }

}
