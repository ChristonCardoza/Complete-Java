package Creational.FactoryMethod;

import Creational.FactoryMethod.message.Message;
import Creational.FactoryMethod.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
