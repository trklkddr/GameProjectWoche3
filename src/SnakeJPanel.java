import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;
public class SnakeJPanel extends JPanel implements ActionListener{
    Musicloader musicloader = new Musicloader();
    Musicloader musicloaderGameMusic = new Musicloader();

    Musicloader musicloaderGameOverSound = new Musicloader();

    Musicloader musicloaderMenueMusic = new Musicloader();
    static final int SpielBreite =550;
    static final int SpielHoehe =550;
    static final int SpielEinheitGroesse =25;
    Timer timer;
    Random random;
    private int score;
    private int food_x;
    private int food_y;
    private int snakeGroesse = 2;
    private int fontHeight;
    private boolean firstRun = true;
    boolean SpielLaeuft = false;
    char richtung = 'R';
    static final int verzoegerung = 80;
    static final int SpielGroesse =(SpielBreite * SpielHoehe)/(SpielEinheitGroesse * SpielEinheitGroesse);
    final int snake_x[]=new int[SpielGroesse];
    final int snake_y[]=new int[SpielGroesse];

    public int getFontHeight() {
        return fontHeight;
    }

    SnakeJPanel(){
        this.setPreferredSize(new Dimension(SpielBreite, SpielHoehe));
        this.setFocusable(true);
        this.addKeyListener(new MyKey());
        random = new Random();
    }

    public void spielStart() {
        foodPosition();
        SpielLaeuft =true;
        timer=new Timer(verzoegerung,this);
        timer.start();
    }
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        draw(graphic);

    }


    public void draw(Graphics graphic) {
        if(SpielLaeuft){
            graphic.fillOval(food_x, food_y, SpielEinheitGroesse, SpielEinheitGroesse);
            for(int i = 0; i< snakeGroesse; i++){
                if(i==0){
                    graphic.fillRect(snake_x[i], snake_y[i], SpielEinheitGroesse, SpielEinheitGroesse);
                }
                else{
                    graphic.fillRect(snake_x[i], snake_y[i], SpielEinheitGroesse, SpielEinheitGroesse);
                }
            }
            FontMetrics font_me=getFontMetrics(graphic.getFont());
            fontHeight = getFontMetrics(graphic.getFont()).getHeight();
            graphic.drawString("Score:"+ score, SpielBreite -font_me.stringWidth("Score:"+ score)- SpielEinheitGroesse, SpielHoehe - SpielEinheitGroesse+20);
            graphic.fillRect(0, 0, SpielBreite - SpielEinheitGroesse, SpielEinheitGroesse /4);
            graphic.fillRect(0, SpielHoehe - SpielEinheitGroesse, SpielBreite - SpielEinheitGroesse, SpielEinheitGroesse /4);
            graphic.fillRect(0, 0, SpielEinheitGroesse /4, SpielHoehe - SpielEinheitGroesse);
            graphic.fillRect(SpielBreite - SpielEinheitGroesse, 0, SpielEinheitGroesse /4, SpielHoehe - SpielEinheitGroesse);

        } else if (firstRun) {
            startMenue(graphic);
            firstRun = false;
        } else {

            gameOver(graphic);
        }

    }
    public void move() {
        for(int i = snakeGroesse; i>0; i--){
            snake_x[i]= snake_x[i-1];
            snake_y[i]= snake_y[i-1];

        }
        switch (richtung) {
            case 'U':
                snake_y[0]= snake_y[0]- SpielEinheitGroesse;
                break;
            case 'L':
                snake_x[0] = snake_x[0] - SpielEinheitGroesse;
                break;
            case 'D':
                snake_y[0] = snake_y[0] + SpielEinheitGroesse;
                break;
            case 'R':
                snake_x[0] = snake_x[0] + SpielEinheitGroesse;
                break;
        }
        if (snake_x[0] < 0 || snake_x[0] >= SpielBreite - SpielEinheitGroesse || snake_y[0] < 0 || snake_y[0] >= SpielHoehe - SpielEinheitGroesse) {
            SpielLaeuft = false;
        }
    }

    public void foodPosition() {
        food_x =random.nextInt((int)((SpielBreite-SpielEinheitGroesse) / SpielEinheitGroesse))* SpielEinheitGroesse;
        food_y =random.nextInt((int)((SpielHoehe-SpielEinheitGroesse) / SpielEinheitGroesse))* SpielEinheitGroesse;
    }
    public void foodGegessen() {
        if((snake_x[0]== food_x)&&(snake_y[0]== food_y)){
            musicloader.loadEatSound();
            snakeGroesse++;
            score++;
            foodPosition();
        }
    }
    public void spielVerlorenKonditionen() {
        for (int i = snakeGroesse; i>0; i--)
        {if((snake_x[0]== snake_x[i])&&(snake_y[0]== snake_y[i]))
        {
            SpielLaeuft =false;}}
        if(snake_x[0]<0)
        {
            SpielLaeuft =false;}
        if(snake_x[0]> SpielBreite)
        { SpielLaeuft =false;}
        if (snake_y[0] < 0)
        {    SpielLaeuft = false;}
        if (snake_y[0] > SpielHoehe)
        {    SpielLaeuft = false;}
        if(!SpielLaeuft) {
            timer.stop();
            musicloaderGameMusic.stopGameMusic();
        }
    }

    public void startMenue(Graphics graphic) {
        graphic.setFont(new Font("", Font.BOLD, 40));
        FontMetrics font_me3 = getFontMetrics(graphic.getFont());
        graphic.drawString("Press space to start", (SpielBreite - font_me3.stringWidth("Press Space to start")) / 2, SpielHoehe / 2-150);
        musicloaderMenueMusic.loadMenuMusic();
    }
    public void gameOver(Graphics graphic) {
        musicloaderGameOverSound.loadGameOverSound();
        graphic.setFont(new Font("", Font.BOLD, 80));
        FontMetrics font_me2 = getFontMetrics(graphic.getFont());
        graphic.drawString("GAME OVER", (SpielBreite - font_me2.stringWidth("GAME OVER"))/2,
                SpielHoehe /2);
        graphic.setFont(new Font("", Font.BOLD, 30));
        FontMetrics font_me3 = getFontMetrics(graphic.getFont());
        graphic.drawString("Press space to play again", (SpielBreite - font_me3.stringWidth("Press Space to play again")) / 2,
                SpielHoehe / 2+150);
        graphic.setFont(new Font("", Font.BOLD, 20));
        FontMetrics font_me = getFontMetrics(graphic.getFont());
        graphic.drawString("Score:" + score, (SpielBreite - font_me.stringWidth("Score:" + score)) / 2,
                SpielHoehe-graphic.getFont().getSize());

    }
    public class MyKey extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(richtung !='R'){
                        richtung ='L';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (richtung != 'D') {
                        richtung = 'U';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (richtung != 'L') {
                        richtung = 'R';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (richtung != 'U') {
                        richtung = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if(!SpielLaeuft){
                        score =0;
                        snakeGroesse =2;
                        richtung ='R';
                        Arrays.fill(snake_x,0);
                        Arrays.fill(snake_y,0);
                        spielStart();
                        //musicloaderGameOverSound.stopGameMusic();
                        musicloaderMenueMusic.stopGameMusic();
                        musicloader.loadStartSound();
                        musicloaderGameMusic.loadGameMusic();
                    }
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (SpielLaeuft) {
            move();
            foodGegessen();
            spielVerlorenKonditionen();
        }
        repaint();
    }

}