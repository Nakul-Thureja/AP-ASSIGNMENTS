package APAssignment4;

public class Player {
    private Bucket myBucket;
    public Player(){
        this.myBucket = new Bucket();
    }
    public void AwardToy(SoftToy myToy){
        this.myBucket.AwardToy(myToy);
    }
    public void printSoftToys(){
        this.myBucket.printToys();
    }
}
