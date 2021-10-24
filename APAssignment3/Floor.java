package APAssignment3;

public abstract class Floor {
    protected int level;
    protected int points;

    public Floor(int level,int points){
        this.level = level;
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public int getLevel() {
        return this.level;
    }

    public abstract void updatePoints(Player player);
    public abstract void updateLevel(Player player);
    public abstract String toString(Player player);
}
