package org.cardoza.sec09.helper;
/*
*  Get all users and build 1 object as shown here.
*  record UserInformation(Integer userId, String Username, Integer balance List<Order> orders) {}
* */

import org.cardoza.common.Util;
import org.cardoza.sec09.application.*;
import reactor.core.publisher.Mono;

import java.util.List;

public class combining13Assignment {

    record UserInformation(Integer userId, String Username, Integer balance, List<Order> orders) {}

    public static void main(String[] args) {

        UserService.getAllUsers()
                .flatMap(combining13Assignment::getUserInformation)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }

    private static Mono<UserInformation> getUserInformation(User user) {
        return Mono.zip(
                PaymentService.getUserBalance(user.id()),
                OrderService.getUserOrder(user.id()).collectList()
        ).map(t ->  new UserInformation(user.id(), user.name(), t.getT1(), t.getT2()));
    }
}
