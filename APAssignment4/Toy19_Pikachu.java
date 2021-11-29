package APAssignment4;

public class Toy19_Pikachu extends SoftToy {
    public Toy19_Pikachu() {
        super("Pikachu");
    }

    @Override
    public Toy19_Pikachu clone() {
        Toy19_Pikachu clone = (Toy19_Pikachu) super.clone();
        return clone;
    }
}
