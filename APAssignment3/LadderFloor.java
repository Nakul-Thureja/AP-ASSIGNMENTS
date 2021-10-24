package APAssignment3;

public class LadderFloor extends Floor{
    public LadderFloor(int level, int points) {
        super(level, points);
    }

    @Override
    public void updateLevel(Player player) {
        player.setLevel(12);
    }

    @Override
    public void updatePoints(Player player) {
        int curr = player.getPoints();
        player.setPoints(curr + 2);
    }

    @Override
    public String toString(Player player) {
        return "Player position Floor - " + player.getLevel() + "\n" +
                player.getName() + " has reached an Ladder Floor\n" +
                "Total points " + player.getPoints() + "\n";
    }
}
