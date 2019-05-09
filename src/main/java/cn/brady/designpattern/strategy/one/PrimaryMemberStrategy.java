package cn.brady.designpattern.strategy.one;

/***
 *
 * 策略模式
 * http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html
 * @author bian.wu
 * @date 2018.9.18
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calculatePrice(double booksPrice) {
        System.out.println("初级会员没有 折扣");
        return booksPrice;
    }
}
