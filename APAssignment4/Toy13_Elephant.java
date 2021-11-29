package APAssignment4;

public class Toy13_Elephant extends SoftToy {
    public Toy13_Elephant() {
        super("Elephant");
    }

    @Override
    public Toy13_Elephant clone() {
        Toy13_Elephant clone = (Toy13_Elephant) super.clone();
        return clone;
    }
}
