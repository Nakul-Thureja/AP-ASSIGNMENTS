package APAssignment2;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LectureSlides implements Uploadable{
    private String topic;
    private int n;
    private ArrayList<String> data;
    private LocalDateTime uploadTime;
    private Instructor instructor;

    public LectureSlides(Instructor instructor){
        TimeZone timezone = TimeZone.getTimeZone("Asia/Calcutta");
        TimeZone.setDefault(timezone);
        this.uploadTime = null;
        this.topic = "";
        this.n = 0;
        this.data = new ArrayList<String>();
        this.instructor = instructor;
    }

    @Override
    public void UpLoad(){
        FastReader sc = new FastReader();
        System.out.println("Enter topic of slides: ");
        this.topic = sc.nextLine();
        System.out.println("Enter number of slides: ");
        this.n = sc.nextInt();
        System.out.println("Enter content of slides ");
        
        for(int i=0;i<n;i++){
            System.out.print("Content of slide "+ (i+1) +": ");
            String content = sc.nextLine();
            data.add(content);
        }
        this.uploadTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String str = "Title: " + this.topic + "\n";
        for (int i = 0; i < this.data.size(); i++) {
            str += "Slide " + (i + 1) + ": " + this.data.get(i) + "\n";
        }
        str += "Number of slides: " + this.n + "\n";
        str += "Date of upload: " + this.uploadTime.getDayOfWeek().name() + " " + date.format(this.uploadTime)  + " IST\n";
        str += "Uploaded by: " + this.instructor.getId() + "\n";
        return str;
    }
}
