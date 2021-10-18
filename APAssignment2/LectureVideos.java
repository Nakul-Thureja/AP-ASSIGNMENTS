package APAssignment2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TimeZone;

public class LectureVideos implements Uploadable{
    private String topic;
    private String filename;
    private LocalDateTime uploadTime;
    private Instructor instructor;

    public LectureVideos(Instructor instructor){
        TimeZone timezone = TimeZone.getTimeZone("Asia/Calcutta");
        TimeZone.setDefault(timezone);
        this.uploadTime = null;
        this.topic = "";
        this.filename = "";
        this.instructor = instructor;
    }

    @Override
    public void UpLoad() {
        FastReader sc = new FastReader();
        String topic,filename;
        System.out.print("Enter topic of video: ");
        topic = sc.nextLine();
        System.out.print("Enter filename of video: ");
        filename = sc.next();
        if (!filename.substring(filename.length() - 4).equals(".mp4")) {
            System.out.println("Wrong file type");
            System.out.println("Please upload an .mp4 file");
            return;
        }
        this.topic = topic;
        this.filename = filename;
        this.uploadTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String str = "Title of video: " + this.topic + "\n";
        str += "Video file: " + this.filename + "\n";
        str += "Date of upload: " + this.uploadTime.getDayOfWeek().name() + " " + date.format(this.uploadTime)  + " IST\n";
        str += "Uploaded by: " + this.instructor.getId() + "\n";
        return str;
    }
}
