package RealExample;

public interface Vehicle {

    String getBrand();

    String speedUp();

    String slowDown();


    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }

    //Eine definierte static Methode in einem Interface
    //gleicht einer Methode aus einer Klasse!
    static double getHorsePowerFromPerformance (double leistungInKW){
        return leistungInKW*1.35962;
    }
    static double getPerformanceFromHorsePower (double horsePower){
        return horsePower/1.35962;
    }
}