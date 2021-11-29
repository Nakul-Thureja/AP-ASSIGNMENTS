package APAssignment4;

public class Toy20_Parrot extends SoftToy {
    public Toy20_Parrot() {
        super("Parrot");
    }

    @Override
    public Toy20_Parrot clone() {
        Toy20_Parrot clone = (Toy20_Parrot) super.clone();
        return clone;
    }
}
