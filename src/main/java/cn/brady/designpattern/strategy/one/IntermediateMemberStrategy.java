package cn.brady.designpattern.strategy.one;


/***
 *
 * 策略模式  中级会员
 * @see cn.brady.designpattern.strategy.one.MemberStrategy
 * http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html
 * @author bian.wu
 * @date 2018.9.18
 */

public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calculatePrice(double booksPrice) {
        System.out.println("中级会员 9折");
        return booksPrice * 0.9;
    }
}
