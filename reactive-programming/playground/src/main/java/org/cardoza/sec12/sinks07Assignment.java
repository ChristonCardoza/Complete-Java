package org.cardoza.sec12;

import org.cardoza.common.Util;
import org.cardoza.sec12.assignment.SlackMember;
import org.cardoza.sec12.assignment.SlackMessages;
import org.cardoza.sec12.assignment.SlackRoom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class sinks07Assignment {

    private static final Logger log = LoggerFactory.getLogger(sinks07Assignment.class);

    public static void main(String[] args) {

        var room = new SlackRoom("reactor");
        var sam  = new SlackMember("sam");
        var jake = new SlackMember("jake");
        var mike = new SlackMember("mike");


        room.addMembers(sam);
        room.addMembers(jake);

        sam.says("Hi all...");
        Util.sleepSeconds(4);

        jake.says("Hey!");
        sam.says("I simply wanted to say hi..");
        Util.sleepSeconds(4);

        room.addMembers(mike);
        mike.says("Hey gus.. glad to be here...");

    }
}
