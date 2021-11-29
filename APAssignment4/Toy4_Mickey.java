package APAssignment4;

public class Toy4_Mickey extends SoftToy {
    public Toy4_Mickey() {
        super("Mickey Mouse");
    }

    @Override
    public Toy4_Mickey clone() {
        Toy4_Mickey clone = (Toy4_Mickey) super.clone();
        return clone;
    }
}