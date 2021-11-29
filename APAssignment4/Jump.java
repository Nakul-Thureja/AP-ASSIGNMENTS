package APAssignment4;
import java.util.Random;

public class Jump {
    private final int numFaces;
    private int jumpValue;

    public Jump() {
        this.numFaces = 25;
        this.jumpValue = -1;
    }

    public void jump() {
        Random rand = new Random();
        int curr_faceValue = 1 + rand.nextInt(this.numFaces);
        setFaceValue(curr_faceValue);
    }

    private void setFaceValue (int value) {
        if (value <= 20)
            this.jumpValue = value;
        else if(value <= this.numFaces){
            this.jumpValue = 21;
        }
    }

    public int getJumpValue() {
        return this.jumpValue;
    }

    @Override
    public String toString() {
        return "Jump at position " + this.jumpValue;
    }
}
