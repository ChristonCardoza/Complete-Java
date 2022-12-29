package Creational.FactoryMethod;

import Creational.FactoryMethod.message.JSONMessage;
import Creational.FactoryMethod.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
