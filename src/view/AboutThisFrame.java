package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Andres Numpaque
 */
public class AboutThisFrame extends JFrame {

    private JLabel info;

    public AboutThisFrame() {

        initComponents();
        this.setVisible(false);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void initComponents() {
        //this.setLayout(new FlowLayout());
        info = new JLabel("<html>"+"Torres de Hanoi v 1.3\n"
                + "Autor: Andres Felipe Suarez Numpaque\n"
                + "Codigo: 201721780"+"</html>");
        add(info);
    }

}
