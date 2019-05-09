package cn.brady.designpattern.strategy.one;


/**
 * 策略模式 客户端
 * http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html
 * @author bian.wu
 * @date 2018.9.18
 */
public class StrategyClient {

    public static void main(String...args){

        MemberStrategy strategy =  new AdvanceMemberStrategy();

        Price price = new Price(strategy);

        double quote = price.quote(300);

        System.out.println("图书最终价格： "+ quote);

    }

}
