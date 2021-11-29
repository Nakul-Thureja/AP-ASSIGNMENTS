package APAssignment4;

public class Toy10_Minion extends SoftToy {
    public Toy10_Minion() {
        super("Minion");
    }

    @Override
    public Toy10_Minion clone() {
        Toy10_Minion clone = (Toy10_Minion) super.clone();
        return clone;
    }
}
