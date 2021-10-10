
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.*;


public class Record{
    private Citizens citizen;
    private ArrayList<slot> slots;
    private String status;

    Record(Citizens citizen){
        this.citizen = citizen;
        this.slots = new ArrayList<slot>();
        this.status = "Registered";
    }

    public String getName(){
        return this.citizen.getName();
    }

    public void add_slot(slot s){
        slots.add(s);
        if(s.getDoses()==slots.size()){
            status = "Fully Vaccinated";
        }
        else{
            status = "Partially Vaccinated";
        }
    }

    public int getintStatus(){
        if(status.equals("Registered")){
            return 0;
        }
        else if(status.equals("Partially Vaccinated")){
            return 1;
        }
        else if(status.equals("Fully Vaccinated")){
            return 2;
        }
        return -1;
    }

    public String getStatus() {
        return this.status;
    }

    public int getNextdate(){
        if(slots.size() == 0){
            return 0;
        }
        return this.slots.get(slots.size() - 1).getnextDose();
    }

    public String getVacName(){
        if(slots.size()==0){
            return "";
        }
        return this.slots.get(slots.size() - 1).getVac();
    }
    public void print_Status(){
        System.out.println(this.status);
        if(status.equals("Registered")){
            return ;
        }
        else if(status.equals("Partially Vaccinated")){
            System.out.println("Vaccine Given: "+this.getVacName());
            System.out.println("Number of Doses Given: "+this.slots.size());
            System.out.println("Next Dose due date: "+this.getNextdate());
        }
        else if(status.equals("Fully Vaccinated")){
            System.out.println("Vaccine Given: "+this.getVacName());
            System.out.println("Number of Doses Given: "+this.slots.size());
        }
    }
    public String getUnique_id(){
        return this.citizen.getUnique_id();
    }
}