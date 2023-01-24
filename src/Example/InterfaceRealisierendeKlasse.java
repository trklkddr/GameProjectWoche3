package Example;

public class InterfaceRealisierendeKlasse implements InterfaceOne, InterfaceTwo {
    //Hier wurde die Methode methode() nicht explizit überschrieben/definiert.


    //Was passiert, wenn wir zwei Interfaces mit gleichnamigen Methoden haben?


    @Override
    public String defaultMethod() {
        return InterfaceOne.super.defaultMethod() +
                InterfaceTwo.super.defaultMethod();
    }
}




