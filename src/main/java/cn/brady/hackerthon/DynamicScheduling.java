package cn.brady.hackerthon;

/**
 * 物流调度 算法 的 整体流程：
 *
 * 订单 用  hashmap存储，id为键，订单对象为值。
 * 排序 列表 只存order id
 *
 * 0-0.订单根据 开始时间，结束时间，进行排序，形成一个 总的列表 为 步骤列表
 *
 * 1-1 计算状态列表，
 * 1-2 根据 步骤列表中的顺序， 逐步计算 最优状态，
 *
 * 2-0. 获取骑手当前位置，计算最优状态，
 * 2-1 状态迁移
 * 2-2 根据最新的状态  计算下一步最优状态。
 * 1.根据 骑手当前位置，按照开始时间排序列表中  确定最佳 取订单骑手
 *
 * 1-1.
 *
 * 2.计算 所有骑手当前 位置 到  商家的位置 的时间，取最短的，为 取
 * 3.计算剩余 骑手到 剩余
 */
public class DynamicScheduling {

    public Order[] orders;
    public Rider[] riders;

    public static void init(){


    }

    //
    public static void getRidersLocations(){



    }


}
