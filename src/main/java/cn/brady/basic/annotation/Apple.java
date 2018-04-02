package cn.brady.basic.annotation;




public class Apple {

    @FruitName("Apple")
    private String name;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String color;

    @FruitProvider(id=1,name = "fucking fruit guy", address = "上海 普陀近铁广场")
    private String provider;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
}
