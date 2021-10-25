package APAssignment3;

public class Player {
    private String name;
    private int points;
    private int level;
    Player(String name){
        this.name = name;
        this.points = 0;
        this.level = -1;
    }

    public boolean check(int move){
        if(this.level == -1){
            return (move == 1);
        }
        return (this.level + move <= 13) ;
    }

    public int getPoints() {
        return this.points;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString(){
        return this.name + " accumulated " + this.points + " points\n";
    }
}
