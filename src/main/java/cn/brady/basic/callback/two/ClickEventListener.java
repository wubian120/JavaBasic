package cn.brady.basic.callback.two;

import java.util.EventListener;

public interface ClickEventListener extends EventListener {
    void click(ClickEvent e);
}
