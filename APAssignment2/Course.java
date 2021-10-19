package APAssignment2;


import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Instructor> instructors = new ArrayList<>();
    private static ArrayList<LectureSlides> lectureSlides = new ArrayList<>();
    private static ArrayList<LectureVideos> lectureVideos = new ArrayList<>();
    private static ArrayList<Assignment> assignments = new ArrayList<>();
    private static ArrayList<Quiz> quizzes = new ArrayList<>();
    private static ArrayList<Comment> comments = new ArrayList<>();


    //Function for Instructor
    public static void addMaterial(Instructor instructor){
        FastReader sc = new FastReader();
        System.out.println("1. Add Lecture Slide");
        System.out.println("2. Add Lecture Video");
        int choice = sc.nextInt();
        if(!(choice==1 || choice==2)){
            System.out.println("Please Enter Valid Choice");
            return;
        }
        if(choice == 1){
            LectureSlides slide = new LectureSlides(instructor);
            slide.UpLoad();
            lectureSlides.add(slide);
        }
        else if(choice == 2){
            LectureVideos video = new LectureVideos(instructor);
            video.UpLoad();
            lectureVideos.add(video);
        }
    }

    public static void addAssessment(Instructor instructor){
        FastReader sc = new FastReader();
        System.out.println("1. Add Assignment");
        System.out.println("2. Add Quiz");
        int choice = sc.nextInt();
        if(!(choice==1 || choice==2)){
            System.out.println("Please Enter Valid Choice");
            return;
        }
        if(choice == 1){
            Assignment assignment = new Assignment(instructor);
            assignment.UpLoad();
            assignments.add(assignment);
        }
        else if(choice == 2){
            Quiz quiz = new Quiz(instructor);
            quiz.UpLoad();
            quizzes.add(quiz);
        }
    }

    public static void viewLectures(){
        System.out.println("Lecture Slides: \n");
        for(int i=0;i<lectureSlides.size();i++){
            System.out.println(lectureSlides.get(i));
        }
        System.out.println("Lecture Videos: \n");
        for(int i=0;i<lectureVideos.size();i++){
            System.out.println(lectureVideos.get(i));
        }
    }

    public static void viewAssessments(){
        System.out.println("Assignments: ");
        for(int i=0;i<assignments.size();i++){
            System.out.println(assignments.get(i));
        }
        System.out.println("\nQuizzes: ");
        for(int i=0;i<quizzes.size();i++){
            System.out.println(quizzes.get(i));
        }
    }

    public static void gradeAssessments(Instructor instructor){
        ArrayList<Gradable> pendingAssessments = new ArrayList<>();
        FastReader sc = new FastReader();
        for(int i=0;i<assignments.size();i++){
            if(assignments.get(i).checkStatus()){
                pendingAssessments.add(assignments.get(i));
            }
        }

        for(int i=0;i<quizzes.size();i++){
            if(quizzes.get(i).checkStatus()){
                pendingAssessments.add(quizzes.get(i));
            }
        }
        if(pendingAssessments.size() == 0){
            System.out.println("No Assessment available to grade");
            return;
        }
        System.out.println("List of assessments");
        for(int i=0;i<pendingAssessments.size();i++){
            System.out.println("ID: "+ i + " " + pendingAssessments.get(i));
            System.out.println("----------------");
        }
        System.out.println("Enter ID of assessment to view submissions: ");
        int choice = sc.nextInt();
        if(choice<0 || choice>=pendingAssessments.size()){
            System.out.println("Please Enter valid choice");
            return;
        }
        pendingAssessments.get(choice).Grade(instructor);
    }

    public static void closeAssessment(Instructor instructor){
        FastReader sc = new FastReader();
        ArrayList<Gradable> openassessment = new ArrayList<>();
        System.out.println("List of Open Assignments: ");
        for(int i=0;i< assignments.size();i++){
            if(assignments.get(i).open()){
                openassessment.add(assignments.get(i));
            }
        }
        for(int i=0;i< quizzes.size();i++){
            if(quizzes.get(i).open()){
                openassessment.add(quizzes.get(i));
            }
        }
        if(openassessment.size()==0){
            System.out.println("No assessment to close currently");
            return ;
        }
        for(int i=0;i< openassessment.size();i++){
            System.out.println("ID " + i + " " + openassessment.get(i));
        }
        System.out.println("Enter id of assignment to close:");
        int index = sc.nextInt();

        if(index<0 || index>=openassessment.size()){
            System.out.println("Please Enter Valid ID");
            return;
        }
        openassessment.get(index).closeAssessment(instructor);
    }

    //Student Functioms
    public static void submitAssessment(Student student){
        ArrayList<Gradable> pending = new ArrayList<>();
        FastReader sc = new FastReader();

        for(int i=0;i<assignments.size();i++){
            double choice = assignments.get(i).viewGrade(student);
            if(choice == -2.0 && assignments.get(i).open()){
                pending.add(assignments.get(i));
            }
         }

        for(int i=0;i<quizzes.size();i++){
            double choice = quizzes.get(i).viewGrade(student);
            if(choice == -2.0 && quizzes.get(i).open()){
                pending.add(quizzes.get(i));
            }
        }
        if(pending.size() == 0) {
            System.out.println("No pending assessments currently");
            return;
        }


        System.out.println("Pending assessments: ");
        for(int i=0;i< pending.size();i++){
            System.out.println("ID " + i + ": " + pending.get(i));
        }
        System.out.print("Enter ID of assessment: ");
        int choice = sc.nextInt();
        if(choice<0 || choice>=pending.size()){
            System.out.println("Please Enter valid choice");
            return;
        }
        pending.get(choice).Submit(student);
    }

    
    public static void studentsAssessments(Student student){
        ArrayList<Gradable> unGraded = new ArrayList<>();
        ArrayList<Gradable> Graded = new ArrayList<>();
        ArrayList<Gradable> pending = new ArrayList<>();
        ArrayList<Gradable> missed = new ArrayList<>();

        for(int i=0;i<assignments.size();i++){
            double choice = assignments.get(i).viewGrade(student);
            if(choice == -1.0){
                unGraded.add(assignments.get(i));
            }
            else if(choice == -2.0){
                if(assignments.get(i).open()){
                    pending.add(assignments.get(i));
                }
                else{
                    missed.add(assignments.get(i));
                }
            }
            else{
                Graded.add(assignments.get(i));
            }

        }

        for(int i=0;i<quizzes.size();i++){
            double choice = quizzes.get(i).viewGrade(student);
            if(choice == -1.0){
                unGraded.add(quizzes.get(i));
            }
            else if(choice == -2.0){
                if(quizzes.get(i).open()){
                    pending.add(quizzes.get(i));
                }
                else{
                    missed.add(quizzes.get(i));
                }
            }
            else{
                Graded.add(quizzes.get(i));
            }
        }

        if(Graded.size() != 0){
            System.out.println("\nGraded submissions: ");
            for(int i=0;i< Graded.size();i++){
                System.out.println(Graded.get(i));
            }
        }

        if(unGraded.size() != 0){
            System.out.println("\nUngraded submissions: ");
            for(int i=0;i< unGraded.size();i++){
                System.out.println(unGraded.get(i));
            }
        }

        if(pending.size() != 0){
            System.out.println("\nPending submissions: ");
            for(int i=0;i< pending.size();i++){
                System.out.println(pending.get(i));
            }
        }

        if(missed.size() != 0){
            System.out.println("\nMissed submissions: ");
            for(int i=0;i< missed.size();i++){
                System.out.println(missed.get(i));
            }
        }
    }

    public static void viewGrades(Student student){
        ArrayList<Gradable> unGraded = new ArrayList<>();
        ArrayList<Gradable> Graded = new ArrayList<>();
        
        for(int i=0;i<assignments.size();i++){
            double choice = assignments.get(i).viewGrade(student);
            if(choice == -1.0){
                unGraded.add(assignments.get(i));
            }
            else if(choice == -2.0){
                continue;
            }
            else{
                Graded.add(assignments.get(i));
            }

        }

        for(int i=0;i<quizzes.size();i++){
            double choice = quizzes.get(i).viewGrade(student);
            if(choice == -1.0){
                unGraded.add(quizzes.get(i));
            }
            else if(choice == -2.0){
                continue;
            }
            else{
                Graded.add(quizzes.get(i));
            }
        }

        System.out.println("\nGraded submissions: ");
        for(int i=0;i< Graded.size();i++){
            System.out.println(Graded.get(i));
            System.out.println(Graded.get(i).getGrade(student));
        }
        System.out.println("\nUngraded submissions: ");
        for(int i=0;i< unGraded.size();i++){
            System.out.println(unGraded.get(i));
        }
        
    }

    //Functions for comments
    //Function Overloading
    public static void addComment(Instructor instructor){
        Comment comment = new Comment();
        comment.addComment(instructor);
        comments.add(comment);
    }

    public static void addComment(Student student){
        Comment comment = new Comment();
        comment.addComment(student);
        comments.add(comment);
    }

    public static void viewComments(){
        System.out.println("Comments: ");
        for(int i=0;i<comments.size();i++){
            System.out.print(comments.get(i));
        }
    }

    public static void InstructorMenu(Instructor instructor){
        FastReader sc = new FastReader();
        while(true){
            System.out.println("\nWelcome " + instructor.getId());
            System.out.println("INSTRUCTOR MENU");
            System.out.println("1. Add class material");
            System.out.println("2. Add assessments");
            System.out.println("3. View lecture materials");
            System.out.println("4. View assessments");
            System.out.println("5. Grade assessments");
            System.out.println("6. Close assessment");
            System.out.println("7. View comments");
            System.out.println("8. Add comments");
            System.out.println("9. Logout");
            System.out.println("Enter Choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addMaterial(instructor);
                    break;
                case 2:
                    addAssessment(instructor);
                    break;
                case 3:
                    viewLectures();
                    break;
                case 4:
                    viewAssessments();
                    break;
                case 5:
                    gradeAssessments(instructor);
                    break;
                case 6:
                    closeAssessment(instructor);
                    break;
                case 7:
                    viewComments();
                    break;
                case 8:
                    addComment(instructor);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Please Enter Valid Choice");
            }
        }
    }

    public static void StudentMenu(Student student){
        FastReader sc = new FastReader();
        while(true) {
            System.out.println("\nWelcome " + student.getId());
            System.out.println("STUDENT MENU");
            System.out.println("1. View lecture materials");
            System.out.println("2. View assessments");
            System.out.println("3. Submit assessment");
            System.out.println("4. View grades");
            System.out.println("5. View comments");
            System.out.println("6. Add comments");
            System.out.println("7. Logout");
            System.out.println("Enter Choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    viewLectures();
                    break;
                case 2:
                    studentsAssessments(student);
                    break;
                case 3:
                    submitAssessment(student);
                    break;
                case 4:
                    viewGrades(student);
                    break;
                case 5:
                    viewComments();
                    break;
                case 6:
                    addComment(student);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Please Enter Valid Choice");
            }
        }
    }

    public static void printStudents(){
        System.out.println("Students: ");
        for(int i=0;i< students.size();i++){
            System.out.println(i + " - " + students.get(i).getId());
        }
    }

    public static void printInstructors(){
        System.out.println("Instructors: ");
        for(int i=0;i< instructors.size();i++){
            System.out.println(i + " - " + instructors.get(i).getId());
        }
    }

    public static void main(String[] args){
        FastReader sc = new FastReader();
        System.out.println("Inializing Backpack.......");
        System.out.print("Enter number of Instructors: ");
        int ni = sc.nextInt();
        System.out.print("Enter number of Students: ");
        int si = sc.nextInt();

        for(int i=0;i<ni;i++){
            instructors.add(new Instructor(i));
        }

        for(int i=0;i<si;i++){
            students.add(new Student(i));
        }
        while(true){
            System.out.println("\nWelcome to Backpack");
            System.out.println("1. Enter as instructor");
            System.out.println("2. Enter as student");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            if(choice == 1){
                printInstructors();
                System.out.print("Choose id: ");
                int id = sc.nextInt();
                if(id<0 || id>= instructors.size()){
                    System.out.println("Please Enter Valid ID");
                }
                else{
                    InstructorMenu(instructors.get(id));
                }
            }
            else if(choice == 2){
                printStudents();
                System.out.print("Choose id: ");
                int id = sc.nextInt();
                if(id<0 || id>= students.size()){
                    System.out.println("Please Enter Valid ID");
                }
                else{
                    StudentMenu(students.get(id));
                }
            }
            else if(choice == 3){
                System.out.println("Exited.......");
                return;
            }
            else{
                System.out.println("Please Enter a Valid Choice");
            }
        }
    }
}
