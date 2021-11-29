package APAssignment4;

public class Toy16_Shark extends SoftToy {
    public Toy16_Shark() {
        super("Baby Shark");
    }

    @Override
    public Toy16_Shark clone() {
        Toy16_Shark clone = (Toy16_Shark) super.clone();
        return clone;
    }
}