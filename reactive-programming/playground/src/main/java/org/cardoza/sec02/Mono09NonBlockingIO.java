package org.cardoza.sec02;

import org.cardoza.common.Util;
import org.cardoza.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mono09NonBlockingIO {

    private static final Logger log = LoggerFactory.getLogger(Mono09NonBlockingIO.class);

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        log.info("Starting");

        for (int i = 1; i <= 100; i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

        log.info("Ending");
        Util.sleepSeconds(2);
    }
}
