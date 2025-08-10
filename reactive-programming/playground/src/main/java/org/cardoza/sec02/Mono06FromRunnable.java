package org.cardoza.sec02;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Mono06FromRunnable {

    public static final Logger log = LoggerFactory.getLogger(Mono06FromRunnable.class);

    public static void main(String[] args) {
        getProductName(1).subscribe(Util.subscriber("1"));

        getProductName(2).subscribe(Util.subscriber("2"));
    }

   public static Mono<String> getProductName(int productId){
        if(productId == 1){
            return Mono.fromSupplier(() -> Util.faker().commerce().productName());
        }

        return Mono.fromRunnable(() -> notifyBusiness(productId));
   }

    private static void notifyBusiness(int productId) {
        log.info("notifying business on unavailable product: {}", productId);
    }
}
