package APAssignment4;

public class Toy17_Giraffe extends SoftToy {
    public Toy17_Giraffe() {
        super("Giraffe");
    }

    @Override
    public Toy17_Giraffe clone() {
        Toy17_Giraffe clone = (Toy17_Giraffe) super.clone();
        return clone;
    }
}
