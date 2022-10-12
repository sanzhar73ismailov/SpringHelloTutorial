package net.proselyte.springioc;

public class MyBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init(){
        System.out.println("init method");
    }

    public void destroy(){
        System.out.println("destroy method");
    }

}
