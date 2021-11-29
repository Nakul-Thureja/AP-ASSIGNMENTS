package APAssignment4;
import java.io.*;

public abstract class Tile {
    private SoftToy myToy;
    private int myPosition;
    private boolean flag;
    private static int position = 1;


    public Tile(SoftToy myToy){
        this.myToy = myToy;
        this.myPosition = position;
        if(this.myPosition%2 == 0){
            this.flag = false;
        }
        else{
            this.flag = true;
        }
        position++;
    }

    public abstract boolean play();

    public boolean getFlag() {
        return this.flag;
    }

    public SoftToy getMyToyClone() throws CloneNotSupportedException{
        SoftToy copy = this.myToy.clone();
        if(copy == null){
            throw new CloneNotSupportedException();
        }
        return copy;
    }

    public String getToyName(){
        return this.myToy.toString();
    }

    @Override
    public String toString() {
        return "You landed on tile " + this.myPosition ;
    }
}
