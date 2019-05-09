package cn.brady.designpattern.strategy.one;


/**
 * 策略模式 中的context 角色
 * http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html
 * @date 2018.9.18
 * @author bian.wu
 */
public class Price {

    private MemberStrategy strategy;

    public Price(MemberStrategy strategy){
        this.strategy = strategy;
    }

    public double quote(double bookPrice){
        return strategy.calculatePrice(bookPrice);
    }

}
