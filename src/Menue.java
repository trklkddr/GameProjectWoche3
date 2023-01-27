import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menue {
    public static void startMenue() {
        // Erstellen eines neuen JFrames
        JFrame frame = new JFrame("Snake");

        //Initialisieren eines Musicloaderobjektes für die Hauptmenumusik
        Musicloader musicloaderMainMenuMusic = new Musicloader();
        musicloaderMainMenuMusic.loadMainMenuMusic();

        // Erstellen Sie zwei Buttons mit den Namen "Start Game" und "Exit"
        JButton openButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");
        JButton creditButton = new JButton("Credits");



        //  ActionListener für den "" Button, der beim Klicken auf den Button ausgelöst wird
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                musicloaderMainMenuMusic.stopWAV();
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

                musicloaderMainMenuMusic.stopWAV();
                System.exit(0);
            }
        });
        creditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Logik, was soll passieren, wenn ich auf den Credits Button klicke?
                Musicloader musicloaderCreditMusic = new Musicloader();
                musicloaderMainMenuMusic.stopWAV();
                musicloaderCreditMusic.loadCreditMusic();
                JFrame frame = new JFrame("Credits");
                frame.setSize(300, 300);
                JButton muteButton = new JButton("mute");
                JButton tamayoButton = new JButton("Tamayo Button");
                muteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        musicloaderCreditMusic.stopWAVinCreditMusic();
                    }
                });
                tamayoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        musicloaderCreditMusic.stopWAV();
                        musicloaderMainMenuMusic.loadMainMenuMusic();
                        frame.setVisible(false); //Musik müsste hier stoppen, wenn Fenster geschlossen wird
                    }
                });
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(muteButton);
                frame.add(muteButton);
                muteButton.setBounds(0, 200, 150, 70);
                frame.add(tamayoButton);
                tamayoButton.setBounds(150, 200, 150, 70);
                JTextArea textArea = new JTextArea();
                textArea.setLineWrap(true); // Enable line wrapping
                textArea.setWrapStyleWord(true); // Wrap at word boundaries
                textArea.setColumns(20); // Set the number of columns
                textArea.setRows(10); // Set the number of rows
                JScrollPane scrollPane = new JScrollPane(textArea);


                String text = "Nikita Smirnov\nTarik Alkad-Dri\nChristian Lange\nBacdasch Zafaryar";
                textArea.setText(text);
                frame.add(scrollPane, BorderLayout.CENTER);
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

