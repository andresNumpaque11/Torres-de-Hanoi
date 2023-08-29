package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;

/**
 *
 * @author Andres Numpaque
 */
public class GameWindow extends JFrame {

    private PanelButtons panelButtons;
    private PanelGame panelGame;

    public GameWindow(ActionListener listener, int selectedTower,Stack<Integer>[] towers) {
        initComponents(listener,towers);
        this.setTitle("Torres de Hanoi");
        this.setSize(800, 600);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    private void initComponents(ActionListener listener,Stack<Integer>[] towers) {
        this.setLayout(new BorderLayout());
        panelButtons = new PanelButtons(listener);
        this.add(panelButtons,BorderLayout.SOUTH);
        panelGame = new PanelGame(towers);
        this.add(panelGame,BorderLayout.CENTER);

    }

    public PanelButtons getPanelButtons() {
        return panelButtons;
    }

    public PanelGame getPanelGame() {
        return panelGame;
    }
    
    public void reset(Stack<Integer>[] towers){
        panelGame.setTowers(towers);
        
    }
    
}
