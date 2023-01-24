package RealExample;

public class Main {
    public static void main(String[] args) {
        System.out.println("Erstelltes Objekt BMW aus der Klasse Car:");
        //Instanziierung des Objekts car aus der Klasse Car
        Vehicle car = new Car("BMW");
        //GetterMethode aus der Klasse Car
        System.out.println(car.getBrand());
        //Methodenaufruf aus der Klasse Car
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());

        /*
        Interessanter Part!
        Beide Methoden sind ausschließlich im Vehicle
        Interface definiert!
         */

        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
        System.out.println("\n\n"+"Erstelltes Objekt Quad:");
        //Beispiel weiterer Klasse ohne explizite Implementierung

        Vehicle quad = new Quad("Yamaha");
        System.out.println(quad.turnAlarmOn() +" " +quad.turnAlarmOff());

        System.out.println("Das Quad hat 117.68kW und entsprechend "+
                Vehicle.getHorsePowerFromPerformance(117.68) +
                "PS!");
        System.out.println("Das Quad hat 160PS und entsprechend "+
                Vehicle.getPerformanceFromHorsePower(160) +
                "kW!");
    }
}
