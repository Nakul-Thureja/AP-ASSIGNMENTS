package APAssignment2;

public class Instructor {
    private String id;
    public Instructor(int id){
        this.id = "I" + Integer.toString(id);
    }
    public String getId(){
        return this.id;
    }
}
