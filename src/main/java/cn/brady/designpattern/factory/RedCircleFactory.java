package cn.brady.designpattern.factory;

/**
 * 抽象工厂模式， 增加 产品族的概念
 * Created by Brady on 2017/5/18.
 */
public class RedCircleFactory implements ShapeFactory {

    @Override
    public Color createColor() {
        return new Red();
    }

    @Override
    public Shape createShape() {
        return new Circle();
    }
}
