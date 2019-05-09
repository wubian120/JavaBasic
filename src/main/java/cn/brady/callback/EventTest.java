/**
 * Copyright (C), 2015-2018, ele me
 * FileName: EventTest
 * Author:   bian.wu
 * Date:     2018/7/16 11:16
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.callback;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Vector;

/**
 * Java Event first example
 *
 * @author bian.wu
 * @create 2018/7/16
 * @since 1.0.0
 */
public class EventTest {


    static class EventClassOne extends EventObject {

        public EventClassOne(Object source) {
            super(source);
        }


    }

    class EventClassTwo extends EventObject {

        public EventClassTwo(Object source) {
            super(source);
        }

    }

    static  class EventSource {
        private String who;
        Vector listeners = new Vector();

        public EventSource(String who) {
            this.who = who;
        }

        public String getActioner() {
            return who;
        }

        public void addMyEventListener(EventListener listener) {
            listeners.add(listener);
        }

        public void say(String words) {

            System.out.println(" this actioner: " + this.getActioner() + " say " + words);

            for(int i=0;i<listeners.size();i++){
                MyEventListener listener = (MyEventListener) listeners.get(i);
                listener.onMyEvent(new EventClassOne(this));
            }


        }
    }


    static class MyEventListener implements EventListener {
        public void onMyEvent(EventObject e) {

            if (e.getSource() instanceof EventSource) {
                EventSource tempSource = (EventSource) e.getSource();
                System.out.println("EventSource: " + tempSource.getActioner() + " event ");
            }

        }

    }


    public static MyEventListener listener = null;
    public static void main(String... args){

        listener = new MyEventListener();
        EventSource white = new EventSource("小白");

        white.addMyEventListener(listener);
        white.say("hello every one");
        white.say("fuck fuck fuck");
    }

}