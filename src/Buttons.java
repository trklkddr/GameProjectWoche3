import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons {
    public static void main(String[] args) {
        // Erstellen eines neuen JFrames
        JFrame frame = new JFrame("Snake");

        // Erstellen Sie zwei Buttons mit den Namen "Open Window" und "Exit"
        JButton openButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        //  ActionListener für den "Open Window" Button, der beim Klicken auf den Button ausgelöst wird
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Snake();
                // An dieser Stelle soll Tariks Spiel implementiert werden
               /* JFrame newFrame = new JFrame("New Window");
                newFrame.setSize(300, 300);
                newFrame.setVisible(true);*/
            }
        });

        // ActionListener für den "Exit" Button, der beim Klicken auf den Button ausgelöst wird
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Beenden Sie das Programm
                System.exit(0);
            }
        });

        // Fügen Sie die Buttons dem JFrame hinzu
        frame.add(openButton);
        frame.add(exitButton);
        frame.setLayout(new FlowLayout());
        // Setzen Sie die Größe des JFrame
        frame.setSize(400, 100);

        // Setzen Sie die Position des JFrame auf die Mitte des Bildschirms
        frame.setLocationRelativeTo(null);

        // Setzen Sie das Verhalten des JFrame beim Schließen auf "EXIT_ON_CLOSE"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Machen Sie das JFrame sichtbar
        frame.setVisible(true);
    }
}

