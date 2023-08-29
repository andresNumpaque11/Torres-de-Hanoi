package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andres Numpaque
 */
public class PanelButtons extends JPanel {
    private JButton[] towerButtons;
    private JButton cancelMovement;

    public PanelButtons(ActionListener listener) {
        initComponents(listener);
    }
    private void initComponents(ActionListener listener){
        towerButtons = new JButton[3];
        for (int i = 0; i < 3; i++) {
           towerButtons[i] = new JButton("Torre "+ (i+1));
           towerButtons[i].addActionListener(listener);
            towerButtons[i].setActionCommand("" + i);
            add(towerButtons[i]);
            
        }
        cancelMovement = new JButton("Cancelar movimiento");
        cancelMovement.addActionListener(listener);
        cancelMovement.setActionCommand("cancelar");
        add(cancelMovement);
    }

    public JButton[] getTowerButtons() {
        return towerButtons;
    }


    
    
    
}
