import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons {
    public static void main(String[] args) {
        // Erstellen eines neuen JFrames
        JFrame frame = new JFrame("Snake");

        // Erstellen Sie zwei Buttons mit den Namen "Start Game" und "Exit"
        JButton openButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");
        JButton creditButton = new JButton("Credits");


        //  ActionListener für den "" Button, der beim Klicken auf den Button ausgelöst wird
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
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

                System.exit(0);
            }
        });
        creditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Logik, was soll passieren, wenn ich auf den Credits Button klicke?
                Musicloader musicloaderCreditMusic = new Musicloader();
                musicloaderCreditMusic.loadCreditMusic();
                JFrame frame = new JFrame("Credits");
                JLabel label = new JLabel("Sadio Mane");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                frame.add(label, BorderLayout.CENTER);
                frame.setSize(300, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });


        // Fügen Sie die Buttons dem JFrame hinzu
        frame.add(openButton);
        frame.add(exitButton);
        frame.add(creditButton);
        frame.setLayout(new FlowLayout());
        // Setzen Sie die Größe des JFrame
        frame.setSize(SnakeJPanel.SpielBreite, SnakeJPanel.SpielHoehe);

        // Setzen Sie die Position des JFrame auf die Mitte des Bildschirms
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Machen Sie das JFrame sichtbar
        frame.setVisible(true);
    }
}

