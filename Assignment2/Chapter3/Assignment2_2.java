
class Gear {
    int chainRing;
    int cog;
    Wheel wheel;

    Gear(int chainVar, int cogVar, int rimVar, double tire) {
        chainRing = chainVar;
        cog = cogVar;
        wheel = new Wheel(rimVar, tire);
    }

    Gear() {
        chainRing = 40;
        cog = 11;
    }

    float ratio() {
        return (float)chainRing/cog;
    }

    float gearInches() {
        return  ratio() * wheel.diameter;
    }
}

class Wheel {
    int rim;
    double tire;
    public static final PI = 3.14;

    Wheel(int rimVar, double tireVar) {
        rim = rimVar;
        tire = tireVar;
    }

    Wheel() {
        rim = 26;
        tire = 1.5;
    }

    double diameter () {
        return (rim + tire * 2);
    }

    double circumference() {
        return diameter() * PI;
    }
}

class Assignment2_2 {

    public static  void main(String[] args) {

        //Wheel wheel = new Wheel(26, 1.5);
        Gear gear1 = new Gear(52, 11, 26, 1.5);
        gearInches1 = gear1.gearInches();
    }
}
