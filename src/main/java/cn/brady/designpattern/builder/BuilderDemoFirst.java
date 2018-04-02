package cn.brady.designpattern.builder;

public class BuilderDemoFirst {

    private int id;
    private String name;
    private ObjectOne objectOne;
    private Double salary;

    private BuilderDemoFirst(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.objectOne = builder.one;
        this.salary = builder.salary;
    }

    @Override
    public String toString() {
        return "id: "+id+" name "+name + " object one name "+ objectOne.getObjName() + " salary ";
    }

    public static class ObjectOne{

        public static final String NAME="ObjectOne Name";

        private String objName;

        public ObjectOne(String name){
            this.objName = name;
        }

        public String getObjName() {
            return objName;
        }
    }


    public static class Builder{

        private int id;
        private String name;
        private Double salary;
        private ObjectOne one;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder salary(double salary){
            this.salary = salary;
            return this;
        }

        public Builder ObjectOne(ObjectOne objectOne){
            this.one = objectOne;
            return this;
        }

        public BuilderDemoFirst create(){
            return new BuilderDemoFirst(this);
        }


    }
    public static void main(String[] args){

        BuilderDemoFirst first = new Builder()
                .id(100)
                .name("demo name")
                .ObjectOne(new ObjectOne("object 3rd"))
                .salary(900.0D).create();


        System.out.println(first);


    }

}
