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
        return this.closeTime == null;
    }

    @Override
    public void closeAssessment(Instructor instructor) {
        this.closeTime = LocalDateTime.now();
        this.closeInstructor = closeInstructor;
    }

    @Override
    public void Submit(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Answer ");
        String answer = sc.nextLine();
        this.submissions.put(student,answer);
        this.grades.put(student,null);
        this.closeTime = LocalDateTime.now();
    }

    @Override
    public void Grade(Instructor instructor) {
        Scanner sc = new Scanner(System.in);


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

        int marks = sc.nextInt();
        if(marks< 0 || marks >= 1){
            System.out.print("Please enter a valid Grade");
            return;
        }

        Grade grade = new Grade(1,marks,instructor);
        this.grades.put(student,grade);
    }

    @Override
    public float viewGrade(Student student) {
        if (this.submissions.get(student) == null) {
            return -2;
        }
        if (this.grades.get(student) == null) {
            return -1;
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
    public void UpLoad() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter quiz statement: ");
        this.problem = sc.nextLine();
        this.openTime = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "Quiz: " + problem ;
    }
}
