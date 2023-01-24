package Example;

public interface InterfaceOne {
    String string = "Ich bin ein String aus dem InterfaceOne";

    /*
    -Default methods sind Methoden, die in Interface-Definitionen bereitgestellt werden
     und eine Standardimplementierung enthalten.
    -Sie wurden in Java 8 eingeführt, um die Möglichkeit zu geben,
     bestehende Interfaces zu erweitern, ohne dass die bereits implementierenden Klassen geändert werden müssen.
    -Ein Interface kann mehrere default Methoden enthalten.
    -Eine Klasse, die ein Interface implementiert, kann die default Methoden verwenden,
     ohne sie explizit zu überschreiben.
    -Wenn eine Klasse die gleiche Methode mit der gleichen Signatur wie eine default Methode bereitstellt,
     hat die Klassenmethode Vorrang vor der default Methode.
    -Default Methoden können auch in anderen Interfaces und in der Klasse selbst überschrieben werden.
     */


    default String methode() {
        return string + " und werde über eine Im Interface definierte Methode zurückgegeben";
    }


    default String defaultMethod() {
        return string + " und wurde in dem Beispiel InterfaceOne sowohl deklariert als auch definiert. Was für ein Wunder!";
    }
}