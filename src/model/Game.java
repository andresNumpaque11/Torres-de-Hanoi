package model;

import java.util.Stack;

/**
 *
 * @author Andres Numpaque
 */
public class Game {

    private Stack<Integer>[] towers;
    private String dificulty;
    private int numDisks;

    public Game(int disks) {
        this.numDisks = disks;
        initializeGame();
    }

    public Game(String dificulty, int disks) {
        this.dificulty = dificulty;
        this.numDisks = disks;
    }
    

    private void initializeGame() {
        towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }
    }

    public boolean checkForWin() {
        if (towers[2].size() == numDisks) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumDisks() {
        return numDisks;
    }

    public Stack<Integer>[] getTowers() {
        return towers;
    }

}
