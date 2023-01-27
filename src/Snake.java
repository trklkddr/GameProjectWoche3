import javax.swing.*;

public class Snake extends JFrame {

    public Snake() {

        //add(ein new Objekt der Klasse, in der das Spiel programmiert wird())
        SnakeJPanel snakeJPanel = new SnakeJPanel();
        this.add(new SnakeJPanel());
        setResizable(false); //Die Fenster sollen nicht verzogen werden, sodass unsere späteren Berechnungen stimmen
        this.setTitle("Snake");
        this.setSize(snakeJPanel.SpielBreite - 5,
                snakeJPanel.SpielHoehe + snakeJPanel.SpielEinheitGroesse + 10);
        this.setLocationRelativeTo(null); //Das Frame soll mittig angezeigt werden
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
