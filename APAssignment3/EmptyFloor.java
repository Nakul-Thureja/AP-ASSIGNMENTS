package APAssignment3;

public class EmptyFloor extends Floor{

    public EmptyFloor(int level, int points) {
        super(level, points);
    }

    @Override
    public void updateLevel(Player player) {
        player.setLevel(player.getLevel());
    }

    @Override
    public void updatePoints(Player player) {
        int curr = player.getPoints();
        player.setPoints(curr + 0);
    }

    @Override
    public String toString(Player player) {
        return "Player position Floor - " + player.getLevel() + "\n" +
                player.getName() + " has reached an Empty Floor\n" +
                "Total points " + player.getPoints() + "\n";
    }
}
