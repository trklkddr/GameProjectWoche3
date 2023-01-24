
package RealExample;

public class Quad implements Vehicle {

    /*
    Man beachte, dass die Methoden turnAlarmOn() und turnAlarmOff() keinerlei
    Erwähnung in unserer Klasse finden und doch jeweils aufgerufen werden können!
     */

    private String brand;

    public Quad(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The Quad is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The Quad is slowing down.";
    }

}