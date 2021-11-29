package APAssignment4;

import java.util.ArrayList;

public class Bucket{
    private ArrayList<SoftToy> myToys;

    public Bucket(){
        this.myToys = new ArrayList<>();
    }
    public void AwardToy(SoftToy myToy){
        this.myToys.add(myToy);
    }
    public void printToys(){
        for(int i=0;i<this.myToys.size()-1;i++){
            System.out.print(this.myToys.get(i) + ", ");
        }
        System.out.print(this.myToys.get(myToys.size()-1));
    }
}
