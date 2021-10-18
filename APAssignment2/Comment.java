package APAssignment2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TimeZone;

public class Comment{
    private String comment;
    private LocalDateTime uploadTime;

    public Comment(){
        TimeZone timezone = TimeZone.getTimeZone("Asia/Calcutta");
        TimeZone.setDefault(timezone);
        this.comment = "";
        this.uploadTime = null;
    }

    public void addComment(Instructor instructor) {
        FastReader sc = new FastReader();
        System.out.println("Enter comment: ");
        this.comment = sc.nextLine() + " - " + instructor.getId() ;
        this.uploadTime = LocalDateTime.now();
    }

    public void addComment(Student student) {
       
        FastReader sc = new FastReader(); 
        System.out.println("Enter comment: ");
        this.comment = sc.nextLine() + " - " + student.getId() ;
        this.uploadTime = LocalDateTime.now();
    }

    @Override
    public String toString(){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return (this.comment + "\n" + "Date of upload: " + this.uploadTime.getDayOfWeek().name()
                + " "  + date.format(this.uploadTime)  + " IST\n");
    }
}
