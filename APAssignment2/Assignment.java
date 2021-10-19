package APAssignment2;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;

public class Assignment implements Uploadable,Gradable{
    private int max;
    private String problem;
    private HashMap<Student,String> submissions;
    private HashMap<Student,Grade> grades;
    private Instructor openInstructor;
    private Instructor closeInstructor;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDateTime submitTime;

    public Assignment(Instructor instructor){
        TimeZone timezone = TimeZone.getTimeZone("Asia/Calcutta");
        TimeZone.setDefault(timezone);
        this.max = 0;
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
    public void closeAssessment(Instructor instructor) {
        this.closeTime = LocalDateTime.now();
        this.closeInstructor = instructor;
    }

    @Override
    public boolean open() {
        return (this.closeTime == null);
    }

    @Override
    public void UpLoad() {
        FastReader sc = new FastReader();
        System.out.print("Enter problem statement: ");
        this.problem = sc.nextLine();
        System.out.print("Enter max marks: ");
        this.max = sc.nextInt();
        this.openTime = LocalDateTime.now();
    }



    @Override
    public void Submit(Student student) {
        if(this.closeTime != null){
            System.out.println("Assignment has been closed by the instructor you cannot submit now");
            return;
        }
        FastReader sc = new FastReader();
        System.out.print("Enter filename of assignment: ");
        String filename = sc.next();
        if (filename.length()<=4 || !filename.substring(filename.length() - 4).equals(".zip")){
            System.out.println("Wrong file type");
            System.out.println("Please upload an .zip file");
            return;
        }
        this.submissions.put(student,filename);
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
        System.out.println(this.submissions.get(student));

        System.out.println("-------------------------------");
        System.out.println("Max Marks: " + this.max);
        System.out.print("Marks scored: ");

        double marks = sc.nextDouble();
        if(marks< 0 || marks > this.max){
            System.out.println("Please enter a valid Grade");
            return;
        }

        Grade grade = new Grade(this.max,marks,instructor);
        this.grades.put(student,grade);
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
    public String getGrade(Student student){
        return "Submission: " + this.submissions.get(student) + "\nMarks scored: " + 
                this.grades.get(student).getGrade() +"\nGraded by: " + this.grades.get(student).getId()+"\n";
    }

    @Override
    public String toString() {
        return "Assignment: " + problem + " Max Marks: " + max ;
    }
}
