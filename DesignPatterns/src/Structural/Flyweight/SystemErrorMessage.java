package Structural.Flyweight;

//A concrete Flyweight. Instance is shared
public class SystemErrorMessage implements ErrorMessage {

    // some error message $errorCode
    private String messageTemplate;

    // http://somdedomain.co/he;p?error=
    private String helpUrlBase;

    public SystemErrorMessage(String messageTemplate, String helpUrlBase){
        this.helpUrlBase = helpUrlBase;
        this.messageTemplate = messageTemplate;
    }

    @Override
    public String getText(String code) {
        return messageTemplate.replace("$errorCode", code) + helpUrlBase + code;
    }
}
