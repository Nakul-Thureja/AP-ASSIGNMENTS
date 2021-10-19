package APAssignment2;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;

public class Quiz implements Uploadable,Gradable{
    private String problem;
    private HashMap<Student,String> submissions;
    private HashMap<Student,Grade> grades;
    private Instructor openInstructor;
    private Instructor closeInstructor;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDateTime submitTime;

    public Quiz(Instructor instructor){
        TimeZone timezone = TimeZone.getTimeZone("Asia/Calcutta");
        TimeZone.setDefault(timezone);
        this.problem = "";
        this.grades = new HashMap<>();
        this.submissions = new HashMap<>();
        this.openInstructor = instructor;
        this.closeInstructor = null;
        this.openTime = null;
        this.closeTime = null;
        this.submitTime = null;
    }

    @Override
    public boolean open() {
        return (this.closeTime == null);
    }

    @Override
    public void closeAssessment(Instructor instructor) {
        this.closeTime = LocalDateTime.now();
        this.closeInstructor = instructor;
    }

    @Override
    public void Submit(Student student) {
        if(this.closeTime != null){
            System.out.println("Assignment has been closed by the instructor you cannot submit now");
            return;
        }
        FastReader sc = new FastReader();
        System.out.print("Enter Answer: ");
        String answer = sc.nextLine();
        this.submissions.put(student,answer);
        this.grades.put(student,null);
        this.submitTime = LocalDateTime.now();
    }

    @Override
    public void Grade(Instructor instructor) {
        FastReader sc = new FastReader();
        System.out.println("Choose ID from these ungraded submissions ");
        int i=0;
        for(Student s: this.submissions.keySet()){
            if(this.grades.get(s) == null){
                System.out.println(i + ". " + s.getId());
                i++;
            }
        }
        if(i == 0){
            System.out.println("No Ungraded submissions currently ");
            return;
        }

        int index = sc.nextInt();

        System.out.print("Submission: ");
        i=0;
        Student student = null;
        boolean flag = true;
        for(Student s: this.submissions.keySet()){
            if(this.grades.get(s) == null){
                if(i==index){
                    flag = false;
                    student = s;
                }
                i++;
            }
        }
        if(flag){
            System.out.println("Please Enter valid ID ");
            return;
        }
        System.out.println(submissions.get(student));

        System.out.println("-------------------------------");
        System.out.println("Max Marks: " + 1);
        System.out.print("Marks scored: ");

        double marks = sc.nextDouble();
        if(marks< 0 || marks > 1){
            System.out.print("Please enter a valid Grade");
            return;
        }

        Grade grade = new Grade(1,marks,instructor);
        this.grades.put(student,grade);
    }

    @Override
    public double viewGrade(Student student) {
        if (this.submissions.get(student) == null) {
            return -2.0;
        }
        if (this.grades.get(student) == null) {
            return -1.0;
        }
        return this.grades.get(student).getGrade();
    }

    @Override
    public boolean checkStatus() {
        for(Student s: this.submissions.keySet()){
            if(this.grades.get(s) == null){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String getGrade(Student student){
        return "Submission: " + this.submissions.get(student) + "\nMarks scored:" + 
                this.grades.get(student).getGrade() +"\nGraded by: " + this.grades.get(student).getId()+"\n";
    }

    @Override
    public void UpLoad() {
        FastReader sc = new FastReader();
        System.out.print("Enter quiz statement: ");
        this.problem = sc.nextLine();
        this.openTime = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "Quiz: " + problem ;
    }
}
