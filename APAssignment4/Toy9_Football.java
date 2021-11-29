package APAssignment4;

public class Toy9_Football extends SoftToy {
    public Toy9_Football() {
        super("Football");
    }

    @Override
    public Toy9_Football clone() {
        Toy9_Football clone = (Toy9_Football) super.clone();
        return clone;
    }
}