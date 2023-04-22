package Behavioral.TemplateMethod;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Abstract base class defines the template method
public abstract class OrderPrinter {

    public final void printOrder(Order order, String filename) {
        try(PrintWriter writer = new PrintWriter(filename)){
            writer.println(start());

            writer.println(formatOrderNumber(order));

            writer.println(formatItems(order));

            writer.println(formatTotal(order));

            writer.println(end());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract String end();
    protected abstract String formatTotal(Order order);

    protected abstract String formatItems(Order order);

    protected abstract String formatOrderNumber(Order order);

    protected abstract String start();
}
