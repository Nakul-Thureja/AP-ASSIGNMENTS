package APAssignment2;

public class Grade {
    private int max;
    private float grade;
    private Instructor instructor;

    public Grade(int max, float grade, Instructor instructor){
        this.max = max;
        this.grade = grade;
        this.instructor = instructor;
    }

    public float getGrade() {
        return this.grade;
    }
}
