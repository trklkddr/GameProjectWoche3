import javax.swing.*;
import java.awt.*;

public class Snake extends JFrame {
    public Snake() {

        //add(ein new Objekt der Klasse, in der das Spiel programmiert wird())

        //setResizable(false); //Die Fenster sollen nicht verzogen werden, sodass unsere späteren Berechnungen stimmen
        setTitle("Snake");
        setSize(600, 600);
        setLocationRelativeTo(null); //Das Frame soll mittig angezeigt werden
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Snake snake = new Snake();
                snake.setVisible(true);
            }
        });
    }

}
