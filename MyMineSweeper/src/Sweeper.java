import sweeper.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Sweeper {

    private static int WIDTH_SIZE; // Длинна окна
    private static int HEIGHT_SIZE; // Высота окна
    private final static int SIZE_BLOCK = 25;
    private static int MAX_BOMBS = 25;//Максимальное число бомб
    private final static String NameWindow = "Sweeper"; // Название окна


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите сложность : \n\t Eazy \n\t Medium \n\t Hard");
        String level = scanner.nextLine();

        if(level.toLowerCase(Locale.ROOT).equals("eazy")){
            HEIGHT_SIZE = 20;
            WIDTH_SIZE = 20;
        } else if(level.toLowerCase(Locale.ROOT).equals("medium")) {
            HEIGHT_SIZE = 25;
            WIDTH_SIZE = 40;
            MAX_BOMBS = MAX_BOMBS*2;
        } else if (level.toLowerCase(Locale.ROOT).equals("hard")) {
            HEIGHT_SIZE = 30;
            WIDTH_SIZE = 60;
            MAX_BOMBS = MAX_BOMBS*3;
        } else {
            System.out.println("Не верный уровень запуск : Medium");
            HEIGHT_SIZE = 25;
            WIDTH_SIZE = 40;
            MAX_BOMBS = 50;
        }

        if (MAX_BOMBS > WIDTH_SIZE * HEIGHT_SIZE / 6) {
            MAX_BOMBS = WIDTH_SIZE * HEIGHT_SIZE / 6;
        }

        GameWindow gameWindow = new GameWindow(WIDTH_SIZE, HEIGHT_SIZE, SIZE_BLOCK, MAX_BOMBS, NameWindow);
        JMenuBar jMenuBar = initMenuBar(gameWindow);
        gameWindow.setJMenuBar(jMenuBar);
    }


    public static JMenuBar initMenuBar(GameWindow gameWindow){
        JMenuBar menuBar = new JMenuBar();



        JMenu jMenu = new JMenu("Menu");
        JMenuItem jMenuItem = new JMenuItem("Author");
        JMenuItem reset = new JMenuItem("new Game");

        reset.addActionListener(e -> {
            gameWindow.removeAll();
            try {
                gameWindow.setContentPane(new GameWindow(WIDTH_SIZE, HEIGHT_SIZE, SIZE_BLOCK, MAX_BOMBS, NameWindow));
            }catch (IllegalArgumentException exception){
                JFrame jFrame = new JFrame("New Game");
                JOptionPane.showMessageDialog(jFrame,"NEW GAME!");
            }
        });

        JFrame jFrame = new JFrame("Author");
        jMenuItem.addActionListener(event ->{
            JOptionPane.showMessageDialog(jFrame,"Strudent Artem....\n IVTZ-21");
        });

        jMenu.add(jMenuItem);
        jMenu.add(reset);
        menuBar.add(jMenu);
        menuBar.setVisible(true);
        return menuBar;
    }
}
