package org.cardoza.sec06.assignment;

import org.cardoza.common.Util;

public class Assignment {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        var inventoryService = new InventoryService();
        var revenueService = new RevenueService();

        client.orderStream().subscribe(inventoryService::consume);
        client.orderStream().subscribe(revenueService::consume);

        inventoryService
                .stream().subscribe(Util.subscriber("inventory"));

        revenueService
                .stream().subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(30);
    }
}
