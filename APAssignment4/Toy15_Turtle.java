package APAssignment4;

public class Toy15_Turtle extends SoftToy {
    public Toy15_Turtle() {
        super("Turtle");
    }

    @Override
    public Toy15_Turtle clone() {
        Toy15_Turtle clone = (Toy15_Turtle) super.clone();
        return clone;
    }
}
