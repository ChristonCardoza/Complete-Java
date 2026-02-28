package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.cardoza.sec09.application.OrderService;
import org.cardoza.sec09.application.PaymentService;
import org.cardoza.sec09.application.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class combining10FluxFlatMap {

    private static final Logger log = LoggerFactory.getLogger(combining10FluxFlatMap.class);


    public static void main(String[] args) {

        UserService.getAllUsers()
                .flatMap(user -> OrderService.getUserOrder(user.id()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }
}
