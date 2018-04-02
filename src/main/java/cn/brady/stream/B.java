package cn.brady.stream;

public class B {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static B toB(A a){
        B b = new B();
        b.setId(a.getId());
        b.setName(a.getName());
        return b;
    }
}
