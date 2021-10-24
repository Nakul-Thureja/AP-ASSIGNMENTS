package APAssignment3;

public class CobraFloor extends Floor{

    public CobraFloor(int level, int points) {
        super(level, points);
    }

    @Override
    public void updateLevel(Player player) {
        player.setLevel(3);
    }

    @Override
    public void updatePoints(Player player) {
        int curr = player.getPoints();
        player.setPoints(curr - 4);
    }

    @Override
    public String toString(Player player) {
        return "Player position Floor - " + player.getLevel() + "\n" +
                player.getName() + " has reached King Cobra\n" +
                "Total points " + player.getPoints() + "\n";
    }
}
