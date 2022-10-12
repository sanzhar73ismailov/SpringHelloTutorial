package net.proselyte.inheritance;

public class Message {
    private String message;

    public Message() {
        System.out.println("Message.constructor");
    }

    public String getMessage() {
        System.out.println("call Message.getMessage()");
        return "Message: " + message;
    }

    public void setMessage(String message) {
        System.out.println("call Message.setMessage()");
        this.message = message;
    }

    public void init() {
        System.out.println("Bean is in init phase");
    }

    public void destroy() {
        System.out.println("Bean is in destroy phase");
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
