package APAssignment4;

public class Toy3_Dog extends SoftToy {
    public Toy3_Dog() {
        super("Scooby Doo Dog");
    }

    @Override
    public Toy3_Dog clone() {
        Toy3_Dog clone = (Toy3_Dog) super.clone();
        return clone;
    }
}