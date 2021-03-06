package cn.brady;

public class EnumPrac {


    public enum Planet{

        MERCURY(3.302e+23, 2.439e6),
        VENUS(4.869e+24, 6.052e6),
        EARTH(5.975e+24, 6.378e6),
        MARS(6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN(8.683e+25, 6.027e7),
        URANUS(8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7);
        ;
        private final double mass;
        private final double radius;
        private final double surfaceGravity;

        private static final double G = 6.67300E-11;

        Planet(double mass, double radius){
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double mass(){return mass;}
        public double radius(){return radius;}
        public double surfaceGravity(){return surfaceGravity;}

        public double surfaceWeight(double mass){
            return mass * surfaceGravity;
        }
    }


    public static void main(String[] args){

        Planet p = Planet.EARTH;

        switch (p){
            case MARS:
                System.out.println("mars");
            case EARTH:
                System.out.println("earth");
            case VENUS:
                System.out.println("venus");

            case SATURN:
                System.out.println("saturn ");
            case URANUS:
                System.out.println("uranus");
                break;
            case JUPITER:
                System.out.println("mass: "+p.mass + " radius: " +p.radius());
        }





    }


}
