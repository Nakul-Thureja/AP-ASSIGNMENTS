package APAssignment2;

public interface Gradable {

    public void Submit(Student student);
    public void Grade(Instructor instructor);
    public double viewGrade(Student student);
    public boolean checkStatus();
    public void closeAssessment(Instructor instructor);
    public boolean open();
}
