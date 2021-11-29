package APAssignment4;

public class Toy1_Teddy extends SoftToy {
    public Toy1_Teddy() {
        super("Teddy Bear");
    }

    @Override
    public Toy1_Teddy clone() {
        Toy1_Teddy clone = (Toy1_Teddy) super.clone();
        return clone;
    }
}
