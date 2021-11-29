package APAssignment4;

public class Toy8_Ball extends SoftToy {
    public Toy8_Ball() {
        super("Ball");
    }

    @Override
    public Toy8_Ball clone() {
        Toy8_Ball clone = (Toy8_Ball) super.clone();
        return clone;
    }
}
