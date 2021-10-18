package APAssignment2;

public class Student {
    private String id;
    public Student(int id){
        this.id = "S" + Integer.toString(id);
    }
    public String getId(){
        return this.id;
    }

}
