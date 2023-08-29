package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import model.Game;
import model.Persistent;
import view.MainWindow;

/**
 *
 * @author Andres Numpaque
 */
public class Controller implements ActionListener {

    private MainWindow mainWindow;
    private Game game;
    private int selectedTower = -1;
    private int secondTower = -1;
    private Map<String, Integer> levels;

    public Controller() {
        levels = Persistent.leerNivelesDesdeArchivo("src/resources/levels.txt");
        game = new Game(3);
        mainWindow = new MainWindow(this, selectedTower, game.getTowers(), levels.keySet());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salir":
                System.exit(0);
                break;
            case "iniciar Juego":
                mainWindow.openGameWindow(true);
                mainWindow.setVisible(false);
                String level = mainWindow.getComboLevel().getSelectedItem().toString();
                int numDisk = levels.get(level);
                System.out.println("el nivel fue " + level + " numero " + numDisk);
                game = new Game(numDisk);
                mainWindow.setTowers(game.getTowers());
                break;
            case "0":
                if (selectedTower == -1) {
                    if (!game.getTowers()[0].isEmpty()) {

                        selectedTower = 0;
                        mainWindow.getbuttons()[0].setEnabled(false);
                    }

                } else if (game.getTowers()[0].isEmpty() || game.getTowers()[0].lastElement() > game.getTowers()[selectedTower].lastElement()) {
                    secondTower = 0;
                }
                break;

            case "1":
                if (selectedTower == -1) {
                    if (!game.getTowers()[1].isEmpty()) {
                        selectedTower = 1;
                        mainWindow.getbuttons()[1].setEnabled(false);
                    }

                } else if (game.getTowers()[1].isEmpty() || game.getTowers()[1].lastElement() > game.getTowers()[selectedTower].lastElement()) {
                    secondTower = 1;
                }

                break;
            case "2":
                if (selectedTower == -1) {
                    if (!game.getTowers()[2].isEmpty()) {
                        selectedTower = 2;
                        mainWindow.getbuttons()[2].setEnabled(false);
                    }
                } else if (game.getTowers()[2].isEmpty() || game.getTowers()[2].lastElement() > game.getTowers()[selectedTower].lastElement()) {
                    secondTower = 2;
                }
                break;
            case "cancelar":
                if (selectedTower != -1) {
                    mainWindow.getbuttons()[selectedTower].setEnabled(true);
                    selectedTower = -1;
                }
                break;
        }
        if (selectedTower != -1 && secondTower
                != -1) {
            game.getTowers()[secondTower].push(game.getTowers()[selectedTower].pop());
            mainWindow.repaintGameWindow();
            mainWindow.getbuttons()[selectedTower].setEnabled(true);
            checkGame();
            selectedTower = -1;
            secondTower = -1;
        }
    }

    public void checkGame() {
        if (game.checkForWin()) {
            mainWindow.isEnableButtons(false);
            mainWindow.showMessage("¡¡Felicitaniones!!\n Ganaste El Juego");
            mainWindow.openGameWindow(false);
            mainWindow.setVisible(true);
            //game = new Game(numdisk);
            mainWindow.resetGame(game.getTowers());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
