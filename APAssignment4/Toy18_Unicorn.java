package APAssignment4;

public class Toy18_Unicorn extends SoftToy {
    public Toy18_Unicorn() {
        super("Unicorn");
    }

    @Override
    public Toy18_Unicorn clone() {
        Toy18_Unicorn clone = (Toy18_Unicorn) super.clone();
        return clone;
    }
}
