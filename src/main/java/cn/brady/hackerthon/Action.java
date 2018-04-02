package cn.brady.hackerthon;

public interface Action {


    /**
     * 移动到指定位置 ，返回移动后 位置
     * @param a
     * @return
     */
    Location moveTo(Location a);


    /**
     * 返回 动作耗时 单位 second
     * @param orderId
     * @return
     */
    long act(long orderId);




}
