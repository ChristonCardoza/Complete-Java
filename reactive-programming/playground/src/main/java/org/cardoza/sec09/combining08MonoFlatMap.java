package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.cardoza.sec09.application.PaymentService;
import org.cardoza.sec09.application.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class combining08MonoFlatMap {

    private static final Logger log = LoggerFactory.getLogger(combining08MonoFlatMap.class);


    public static void main(String[] args) {

        UserService.getUserId("sam")
                .flatMap(PaymentService::getUserBalance)
                .subscribe(Util.subscriber());

        UserService.getUserId("mike")
                .flatMap(PaymentService::getUserBalance)
                .subscribe(Util.subscriber());
    }
}
