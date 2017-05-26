package cn.brady.designpattern.decorator;

/**
 * Created by Brady on 2017/5/11.
 */
public class Milk extends CondimentDecorator {

    protected Beverage beverage;

    public Milk(Beverage b){
        this.beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.description + " with milk. ";
    }

    @Override
    public double cost() {
        return 2.3 + beverage.cost();
    }
}
