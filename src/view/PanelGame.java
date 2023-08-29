package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;
import javax.swing.JPanel;

/**
 *
 * @author Andres Numpaque
 */
public class PanelGame extends JPanel {

    private Stack<Integer>[] towers;

    public PanelGame(Stack<Integer>[] towers) {
        this.towers = towers;
    }


    private void drawDisc(Graphics g, int towerIndex, int discIndex) {
        int discWidth = 30 + towers[towerIndex].get(discIndex) * 20;
        int x = towerIndex * getWidth() / 3 + (getWidth() / 3 - discWidth) / 2;
        int y = getHeight() - (discIndex + 1) * 20 - 50; // Offset to raise the discs
        g.setColor(Color.BLUE);
        g.fillRect(x, y, discWidth, 15);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < towers[i].size(); j++) {
                drawDisc(g, i, j);
            }
        }
    }

    public void setTowers(Stack<Integer>[] towers) {
        this.towers = towers;
    }
    
}
