package APAssignment4;

public class Toy11_Monkey extends SoftToy {
    public Toy11_Monkey() {
        super("Monkey");
    }

    @Override
    public Toy11_Monkey clone() {
        Toy11_Monkey clone = (Toy11_Monkey) super.clone();
        return clone;
    }
}
