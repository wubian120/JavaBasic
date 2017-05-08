package cn.brady.generic;

/**
 * Created by Brady on 2017/5/5.
 */
public class MessageImpl implements Message<String>  {
    private String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "Message: " + message;
    }

    public static void main(String[] args){

        MessageImpl messageImpl = new MessageImpl();
        messageImpl.setMessage("hahahahahahahaha");

        System.out.println(messageImpl);
    }

}
