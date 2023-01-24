package RealExample;

public class Car implements Vehicle {

    /*
    Man beachte, dass die Methoden turnAlarmOn() und turnAlarmOff() keinerlei
    Erwähnung in unserer Klasse finden und doch jeweils aufgerufen werden können!
     */

    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

}