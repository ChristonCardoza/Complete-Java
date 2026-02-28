package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.cardoza.sec09.helper.Kayak;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class combining06mergeUsecase {

    private static final Logger log = LoggerFactory.getLogger(combining06mergeUsecase.class);

    public static void main(String[] args) {

        Kayak.getFlights()
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }
}
