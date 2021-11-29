package APAssignment4;

public class EvenTile extends Tile{
    public EvenTile(SoftToy myToy){
        super(myToy);
    }
    
    @Override
    public boolean play(){
        System.out.println("You won a " + this.getToyName() + " soft toy\n");
        return true;
    }
}
