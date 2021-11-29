package APAssignment4;

public class Toy12_Dino extends SoftToy {
    public Toy12_Dino() {
        super("Dinosaur");
    }

    @Override
    public Toy12_Dino clone() {
        Toy12_Dino clone = (Toy12_Dino) super.clone();
        return clone;
    }
}
