package APAssignment3;
import java.util.Random;

public class Dice {
    private final int numFaces;
    private int faceValue;

    public Dice() {
        this.numFaces = 2;
    }

    public void roll() {
        Random rand = new Random();
        int curr_faceValue = 1 + rand.nextInt(this.numFaces);
        setFaceValue(curr_faceValue);
    }

    private void setFaceValue (int value) {
        if (value <= this.numFaces)
            this.faceValue = value;
    }

    public int getFaceValue() {
        return this.faceValue;
    }

    public int getNumFaces() {
        return this.numFaces;
    }

    @Override
    public String toString() {
        return "Dice gave " + this.faceValue;
    }
}

