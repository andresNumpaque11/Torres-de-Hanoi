package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andres Numpaque
 */
public class PanelButtons extends JPanel {

    private JButton[] towerButtons;
    private JButton cancelMovement;
    private ImageIcon image;

    public PanelButtons(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        towerButtons = new JButton[3];
        for (int i = 0; i < 3; i++) {
            towerButtons[i] = new JButton();
            towerButtons[i].addActionListener(listener);
            towerButtons[i].setActionCommand("" + i);
            createButton("src/resources/"+i+".png", towerButtons[i], 0, 0, 78, 46);
            add(towerButtons[i]);
            

        }
        

        cancelMovement = new JButton();
        cancelMovement.addActionListener(listener);
        cancelMovement.setActionCommand("cancelar");
        createButton("src/resources/cancel.png", cancelMovement, 0, 0, 78, 46);
        add(cancelMovement);
        image = new ImageIcon("src/resources/fondoJuego.jpeg");
    }

    public void createButton(String path, JButton buttonGeneric, int x, int y, int w, int h) {
        buttonGeneric.setOpaque(false);
        buttonGeneric.setContentAreaFilled(false);
        buttonGeneric.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonGeneric.setBorderPainted(false);
        buttonGeneric.setFocusable(false);
        buttonGeneric.setBounds(x, y, w, h);
        ImageIcon images = new ImageIcon(path);
        Icon icon = new ImageIcon(images.getImage().getScaledInstance(buttonGeneric.getWidth(), buttonGeneric.getHeight(), Image.SCALE_DEFAULT));
        buttonGeneric.setIcon(icon);
        add(buttonGeneric);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = image.getImage();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    }

    public JButton[] getTowerButtons() {
        return towerButtons;
    }

}
