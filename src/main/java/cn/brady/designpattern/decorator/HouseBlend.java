package cn.brady.designpattern.decorator;

/**
 * Created by Brady on 2017/5/11.
 */
public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "House Blend coffee";
    }


    @Override
    public double cost() {
        return 4.9;
    }
}

