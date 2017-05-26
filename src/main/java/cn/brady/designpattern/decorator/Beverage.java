package cn.brady.designpattern.decorator;

/**
 * Created by Brady on 2017/5/11.
 */
public abstract class Beverage {

    protected String description = "";
    public String getDescription(){return description;}

    public abstract double cost();

}
