package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Andres Numpaque
 */
public class PanelGame extends JPanel {

    private Stack<Integer>[] towers;
    private Fondo fondo;
    private ImageIcon image;

    public PanelGame(Stack<Integer>[] towers) {
        this.setLayout(null);
        this.towers = towers;
        image = new ImageIcon("src/resources/fondoJuego.jpeg");
        Image background= image.getImage();
        fondo = new Fondo(background);
        fondo.setBounds(0, 0, 800, 600);
        add(fondo);
    }


    private void drawDisc(Graphics g, int towerIndex, int discIndex) {
        int discWidth = 30 + towers[towerIndex].get(discIndex) * 20;
        int x = towerIndex * getWidth() / 3 + (getWidth() / 3 - discWidth) / 2;
        int y = getHeight() - (discIndex + 1) * 20 - 50; // Offset to raise the discs
        int cornerRadius = 10;
        g.setColor(Color.GREEN);
        g.fillRoundRect(x, y, discWidth, 15,cornerRadius,cornerRadius);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < towers[i].size(); j++) {
                drawDisc(g, i, j);
            }
        }
        int columnWidth = getWidth() / 3;
    int columnHeight = getHeight() - 250; // Altura de las columnas

    for (int i = 0; i < 3; i++) {
        int x = i * columnWidth;
        int y = getHeight() - columnHeight;

        g.setColor(Color.WHITE); 
        g.fillRect(x + columnWidth / 2 - 10, y-50, 20, columnHeight); // Dibujar columnas

        for (int j = 0; j < towers[i].size(); j++) {
            drawDisc(g, i, j);
        }
    }
    }

    public void setTowers(Stack<Integer>[] towers) {
        this.towers = towers;
    }
    
}
