package APAssignment4;

public class Toy2_Duck extends SoftToy {
    public Toy2_Duck() {
        super("Donald Duck");
    }

    @Override
    public Toy2_Duck clone() {
        Toy2_Duck clone = (Toy2_Duck) super.clone();
        return clone;
    }
}