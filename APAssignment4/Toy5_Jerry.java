package APAssignment4;

public class Toy5_Jerry extends SoftToy {
    public Toy5_Jerry() {
        super("Jerry the Mouse");
    }

    @Override
    public Toy5_Jerry clone() {
        Toy5_Jerry clone = (Toy5_Jerry) super.clone();
        return clone;
    }
}
