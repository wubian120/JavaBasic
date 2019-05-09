package cn.brady.basic.callback.two;

import java.util.EventObject;
import java.util.concurrent.ThreadPoolExecutor;

public class ClickEvent extends EventObject {

    private EventSource eventSource;

    public ClickEvent(EventSource eventSource){
        super(eventSource);
        this.eventSource = eventSource;
    }



}
