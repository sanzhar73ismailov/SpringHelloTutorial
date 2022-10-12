package net.proselyte.inheritance;

public class MessageToYou {
    private String message;
    private String messageToYou;

    public MessageToYou() {
        System.out.println("Message.constructor");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageToYou() {
        return messageToYou;
    }

    public void setMessageToYou(String messageToYou) {
        this.messageToYou = messageToYou;
    }

    public void init() {
        System.out.println("Bean is in init phase");
    }

    public void destroy() {
        System.out.println("Bean is in destroy phase");
    }

    @Override
    public String toString() {
        return "MessageToYou{" +
                "message='" + message + '\'' +
                ", messageToYou='" + messageToYou + '\'' +
                '}';
    }
}
