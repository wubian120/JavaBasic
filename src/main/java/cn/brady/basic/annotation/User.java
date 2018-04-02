package cn.brady.basic.annotation;


@Table("user")
public class User {
    @Column("id")
    private int id;

    @Column("name")
    private String name;

    @Column("age")
    private int age;

    @Column("address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
