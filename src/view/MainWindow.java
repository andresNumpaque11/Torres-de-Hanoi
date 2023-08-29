package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Stack;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Numpaque
 */
public class MainWindow extends JFrame {

    private JButton btnStartGame;
    private JButton btnExit;
    private JButton btnAbout;
    private ImageIcon image;
    private Fondo fondo;
    private JComboBox comboLevel;

    private GameWindow gameWindow;
    private AboutThisFrame aboutThisFrame;

    public MainWindow(ActionListener listener, int selectedTower, Stack<Integer>[] towers, Set<String> keySet) {
        initComponents(listener, selectedTower, towers, keySet);
        this.setTitle("Torres de Hanoi");
        this.setSize(450, 450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public void setTowers(Stack<Integer>[] towers){
        gameWindow.getPanelGame().setTowers(towers);
    }

    private void initComponents(ActionListener listener, int selectedTower, Stack<Integer>[] towers, Set<String> keySet) {
        this.setLayout(null);
        btnStartGame = new JButton();
        createButton("src/resources/start.png", btnStartGame, 150, 100, 100, 50);
        btnStartGame.addActionListener(listener);
        btnStartGame.setActionCommand("iniciar Juego");
        comboLevel = new JComboBox();
        configureLevel(keySet,comboLevel);
        comboLevel.setBounds(150, 200, 100, 30);
        add(comboLevel);
        btnExit = new JButton("Exit");
        btnExit.addActionListener(listener);
        btnExit.setActionCommand("salir");
        createButton("src/resources/exit.png", btnExit, 150, 300, 100, 50);
        btnAbout = new JButton("Acerca de...");
        btnAbout.addActionListener(listener);
        btnAbout.setActionCommand("abrirAcercade");
        createButton("src/resources/info.jpg", btnAbout, 400, 0, 50, 50);
        image = new ImageIcon("src/resources/fondo2.jpg");
        Image background = image.getImage();
        fondo = new Fondo(background);
        fondo.setBounds(0, 0, 450, 450);
        add(fondo);

        gameWindow = new GameWindow(listener, selectedTower, towers);
        aboutThisFrame = new AboutThisFrame();

    }

    private void configureLevel(Set<String> data, JComboBox comboLevel) {
        for (String level : data) {
            comboLevel.addItem(level);
        }
    }

    public void createButton(String path, JButton buttonGeneric, int x, int y, int w, int h) {
        buttonGeneric.setBackground(Color.WHITE);
        buttonGeneric.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonGeneric.setPreferredSize(new Dimension(200, 40));
        buttonGeneric.setBorderPainted(false);
        buttonGeneric.setFocusable(false);
        buttonGeneric.setBounds(x, y, w, h);
        ImageIcon image = new ImageIcon(path);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(buttonGeneric.getWidth(), buttonGeneric.getHeight(), Image.SCALE_DEFAULT));
        buttonGeneric.setIcon(icon);
        add(buttonGeneric);
    }

    public void openGameWindow(boolean b) {
        gameWindow.setVisible(b);
    }
    public void openCloseWindow(boolean b){
        aboutThisFrame.setVisible(b);
    }

    public JButton[] getbuttons() {
        return gameWindow.getPanelButtons().getTowerButtons();
    }

    public void isEnableButtons(boolean b) {
        for (JButton button : getbuttons()) {
            button.setEnabled(b);
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void repaintGameWindow() {
        gameWindow.getPanelGame().repaint();
    }

    public void resetGame(Stack<Integer>[] towers) {
        gameWindow.reset(towers);
        repaintGameWindow();
        isEnableButtons(true);
    }

    public JComboBox getComboLevel() {
        return comboLevel;
    }

}
