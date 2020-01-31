class Gear {
    int chainRing;
    int cog;
    //Wheel wheel;

    Gear(int chainVar, int cogVar) {
        chainRing = chainVar;
        cog = cogVar;
        //wheel = new Wheel(rimVar, tire);
    }

    float ratio() {
        return (float)chainRing/cog;
    }

    float gearInches(double diameter) {
        return  ratio() * diameter;
    }
}

class Wheel {
    int rim;
    double tire;
    Gear gear;
    public static final PI = 3.14;

    Wheel(int rimVar, double tireVar, int chainVar, int cogVar) {
        rim = rimVar;
        tire = tireVar;
        gear = new Gear(chainVar, cogVar);
    }

    double diameter () {
        return (rim + tire * 2);
    }

    double circumference() {
        return diameter() * PI;
    }

    double gearInches() {
        return gear.gearInches(diameter());
    }
}

class Assignment2_3 {
    public static  void main(String[] args) {

        Wheel wheel = new Wheel(26, 1.5);
        //Gear gear1 = new Gear(52, 11, 26, 1.5);
        gearInches1 = wheel.gearInches();
    }
}
