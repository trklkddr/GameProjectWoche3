package Example;

public class Main {


    public static void main(String[] args) {
        InterfaceRealisierendeKlasse objekt = new InterfaceRealisierendeKlasse();

        //.. und trotzdem können wir sie hier aufrufen!
        //System.out.println(objekt.methode());
        System.out.println(objekt.defaultMethod());
    }


    //Mit Überschreiben der Methoden können wir genau definieren, ob und wie
    //genau wir solche Methoden verwenden können

}
