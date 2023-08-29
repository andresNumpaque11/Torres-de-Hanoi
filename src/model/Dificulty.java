package model;

/**
 *
 * @author Andres Numpaque
 */
public class Dificulty {
    private String level;
    private int disks;

    public Dificulty(String level, int disks) {
        this.level = level;
        this.disks = disks;
    }

    public int getDisks() {
        return disks;
    }

    public String getLevel() {
        return level;
    }
    
    
    
}
