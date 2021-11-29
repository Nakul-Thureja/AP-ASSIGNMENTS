package APAssignment4;

public class Toy6_Tom extends SoftToy {
    public Toy6_Tom() {
        super("Tom the Cat");
    }

    @Override
    public Toy6_Tom clone() {
        Toy6_Tom clone = (Toy6_Tom) super.clone();
        return clone;
    }
}
