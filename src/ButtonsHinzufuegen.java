import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsHinzufuegen extends JFrame {
    public ButtonsHinzufuegen() {
        //Wir erstellen ein Frame
        setTitle("Unser Game");
        setSize(545, 585); //Tariks Variablen verwenden
        setLocationRelativeTo(null); //Das Frame soll mittig angezeigt werden
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Wir erstellen  ein Button
        JButton button = new JButton("Spiel verlassen");
        //button.setBounds(10, 10, 100, 20);

        JButton button2 = new JButton("spielen");

        JButton button3 = new JButton("weiteres Feature");

        //Wir definieren, was unser Button tun kann
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //In dieser Zeile geben wir an, was unser Button tun soll
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //wenn wir auf spielen klicken, müssen wir das Game starten können
            }
        });


        //wir erstellen ein Layout
        Container pane = getContentPane();
        //pane.setLayout(null); //null bedeutet, dass wir erstmal kein Layout haben möchten
        pane.setLayout(new FlowLayout()); //Es gibt verschiedenste Layouts bsp. BorderLayout(), GridLayout() etc.
        pane.add(button); //wir fügen unserem Layout unser Button hinzu
        pane.add(button2);
        pane.add(button3);


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonsHinzufuegen bt = new ButtonsHinzufuegen ();
                bt.setVisible(true);
            }
        });
    }
}



