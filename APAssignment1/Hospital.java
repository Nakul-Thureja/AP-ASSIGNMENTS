package APAssignment1;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.*;


public class Hospital{

    private static int total=0;
    private String name;
    private String pincode;
    private String unique_id;
    private HashMap<slot, Integer> Slots;

    public Hospital(String name,String pincode){
        this.name = name;
        this.pincode = pincode;
        this.unique_id = String.format("%06d", total);
        total++;
        Slots = new HashMap<slot,Integer>();
    }

    public String toString(){
        return ("Hospital Name: "+this.name+", Pincode: "+this.pincode
                +", Unique ID: "+ this.unique_id);
    }

    public String getUnique_id(){
        return this.unique_id;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void add_Slots(slot s, int qty){
        s.setHospital(this);
        this.Slots.put(s,qty);
        System.out.println("Slot added by Hospital "+this.unique_id+" for Day: "+s.getDay()+
                          ", Quantity:" + Slots.get(s) + " of Vaccine " + s.getVac());
    }

    public void book_Slot(Record record){
        Scanner sc =  sc = new Scanner(System.in);
        int next = record.getNextdate();
        String vac_name = record.getVacName();
        int pos = 0;

        ArrayList<slot> avaialable_slots = new ArrayList<>();
        for(slot s: this.Slots.keySet()){
            if(s.getDay() >= next){
                if(vac_name.equals("") || vac_name.equals(s.getVac())){
                    System.out.println(pos + "-> Day: " + s.getDay()  + " Available Qty: " + this.Slots.get(s) + " Vaccine:" + s.getVac());
                    pos++;
                    avaialable_slots.add(s);
                }
            }
        }

        if(pos == 0){
            System.out.println("No slot possible available.....try later");
            return;
        }

        System.out.println("Choose Slot: ");
        int choice = sc.nextInt();

        if(choice<0 || choice>=pos){
            System.out.println("Please Enter Valid index");
            return;
        }

        slot s = avaialable_slots.get(choice);

        int qty = this.Slots.get(s);
        if(qty==1){
            this.Slots.remove(s);
        }
        else{
            this.Slots.put(s,qty-1);
        }
        record.add_slot(s);
        System.out.println(record.getName() + " succesfully vaccinated with " + record.getVacName());
    }

    public boolean print_Slotsbyname(String vaccine_name){
        boolean flag = false;
        for(slot s: this.Slots.keySet()){
            if(vaccine_name.equals(s.getVac())) {
                flag = true;
            }
        }
        if(flag) {
            System.out.println(this);
        }
        return flag;
    }

    public boolean print_Slotsbypincode(String pincode){
        boolean flag = false;
        if(this.pincode.equals(pincode)) {
            flag = true;
            System.out.println(this);
        }
        return flag;
    }

    public void print_slots(){
        int pos = 0;
        for(slot s: this.Slots.keySet()){
            System.out.println(pos + "-> Day: " + s.getDay() + " Available Qty: " + this.Slots.get(s) + " Vaccine:" + s.getVac());
            pos++;
        }
    }
}