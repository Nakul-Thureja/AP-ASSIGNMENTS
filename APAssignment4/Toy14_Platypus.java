package APAssignment4;

public class Toy14_Platypus extends SoftToy {
    public Toy14_Platypus() {
        super("Perry the Platypus");
    }

    @Override
    public Toy14_Platypus clone() {
        Toy14_Platypus clone = (Toy14_Platypus) super.clone();
        return clone;
    }
}
