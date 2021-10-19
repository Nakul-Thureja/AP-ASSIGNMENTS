package APAssignment2;

public class Grade {
    private int max;
    private double grade;
    private Instructor instructor;

    public Grade(int max, double grade, Instructor instructor){
        this.max = max;
        this.grade = grade;
        this.instructor = instructor;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getId(){
        return this.instructor.getId();
    }
}
