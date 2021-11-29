package APAssignment4;

public class Toy7_Panda extends SoftToy {
    public Toy7_Panda() {
        super("Panda Bear");
    }

    @Override
    public Toy7_Panda clone() {
        Toy7_Panda clone = (Toy7_Panda) super.clone();
        return clone;
    }
}
