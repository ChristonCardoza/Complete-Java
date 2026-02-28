package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.cardoza.sec09.application.OrderService;
import org.cardoza.sec09.application.PaymentService;
import org.cardoza.sec09.application.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class combining09MonoFlatMapMany {

    private static final Logger log = LoggerFactory.getLogger(combining09MonoFlatMapMany.class);


    public static void main(String[] args) {

        UserService.getUserId("sam")
                .flatMapMany(OrderService::getUserOrder)
                .subscribe(Util.subscriber());

        UserService.getUserId("mike")
                .flatMapMany(OrderService::getUserOrder)
                .subscribe(Util.subscriber());

        UserService.getUserId("jake")
                .flatMapMany(OrderService::getUserOrder)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);


    }
}
