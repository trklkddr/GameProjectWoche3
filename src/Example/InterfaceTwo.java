package Example;

public interface InterfaceTwo {
    String string ="Ich bin aus dem Beispiel InterfaceTwo";

    default String defaultMethod(){
        return "\n\n" +string + " und wurde in dem Beispiel InterfaceTwo sowohl deklariert als auch definiert. Was für ein Wunder!";
    }
}
