package APAssignment1;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.*;


public class Covin{
    private ArrayList<vaccine> Vaccines;
    private ArrayList<Hospital> hospitals;
    private ArrayList<Record> records;

    public Covin(){
        Vaccines = new ArrayList<vaccine>();
        hospitals = new ArrayList<Hospital>();
        records = new ArrayList<Record>();
    }

    public void Add_Vaccine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vaccine Name: ");
        String vaccine_name = sc.next();
        System.out.println("Number of Doses: ");
        int doses = sc.nextInt();
        int gap = 0;
        if(doses > 1){
            System.out.println("Gap between Doses: ");
            gap = sc.nextInt();
        }

        vaccine vac = new vaccine(vaccine_name,doses,gap);
        Vaccines.add(vac);
        System.out.println(vac);
    }

    public void Add_Hospital(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hospital Name: ");
        String hospital_name = sc.nextLine();
        System.out.println("PinCode: ");
        String Pincode = sc.next();
        Hospital hospital = new Hospital(hospital_name,Pincode);
        hospitals.add(hospital);
        System.out.println(hospital);
    }

    public void Add_Citizen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Citizen Name: ");
        String citizen_name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        System.out.println("Unique ID: ");
        String unique_id = sc.next();
        if(unique_id.length()!=12){
            System.out.println("Invalid Id");
            return;
        }
        Citizens citizen = new Citizens(citizen_name,age,unique_id);
        System.out.println(citizen);
        if(age >= 18) {
            records.add(new Record(citizen));
        }
        else{
            System.out.println("Only above 18 are allowed");
        }

    }

    public void Add_slot(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hospital ID: ");
        String unique_id = sc.next();
        int hospital_id = -1;
        boolean flag = true;
        for (int i = 0; i < hospitals.size(); i++) {
            if (unique_id.equals(hospitals.get(i).getUnique_id())) {
                flag = false;
                hospital_id = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Please Enter Valid hospital id");
            return;
        }

        System.out.println("Enter number of Slots to be added: ");
        int n = sc.nextInt();
        while(n-->0) {
            System.out.println("\nEnter Day Number: ");
            int day = sc.nextInt();
            System.out.println("Enter Quantity: ");
            int quantity = sc.nextInt();
            System.out.println("Select Vaccine");

            for (int i = 0; i < Vaccines.size(); i++) {
                System.out.println(i + ". " + Vaccines.get(i).getVaccine_name());
            }

            int v = sc.nextInt();
            if(v<0 || v>=Vaccines.size()){
                System.out.println("Please Enter Valid Index");
                return;

            }

            slot s = new slot(day, Vaccines.get(v));
            hospitals.get(hospital_id).add_Slots(s, quantity);
        }
    }

    public void book_slot(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter patient Unique ID: ");
        String citizen_id = sc.next();

        int citizen_index = -1;
        boolean flag = true;

        for(int i=0;i<records.size();i++){
            if(citizen_id.equals(records.get(i).getUnique_id())){
                flag = false;
                citizen_index = i;
                break;
            }
        }

        if(flag){
            System.out.println("Please register first on the covin portal");
            return;
        }

        if(records.get(citizen_index).getintStatus()==2){
            System.out.println("You are fully vaccinated and you can not book more slots");
            return;
        }

        System.out.println("1. Search by area");
        System.out.println("2. Search by Vaccine");
        System.out.println("3. Exit");
        System.out.println("Enter option: ");

        flag = false;
        int op = sc.nextInt();
        if(op==3){
            System.out.println("Exited...");
            return;
        }
        if(op == 2){
            System.out.println("Enter Vaccine name: ");
            String name = sc.next();
            for(int i=0;i<hospitals.size();i++){
                flag = flag || hospitals.get(i).print_Slotsbyname(name);
            }
        }
        if(op == 1) {
            System.out.println("Enter PinCode: ");
            String pincode = sc.next();
            for(int i=0;i<hospitals.size();i++){
                flag = flag || hospitals.get(i).print_Slotsbypincode(pincode);
            }
        }
        
        if(!flag){
            System.out.println("No Hospitals Available");
            return;
        }
        
        System.out.println("Enter hospital id: ");
        String hospital_id = sc.next();
        flag = true;
        int hospital_index = -1;
        for(int i=0;i<hospitals.size();i++){
            if(hospital_id.equals(hospitals.get(i).getUnique_id())){
                hospitals.get(i).book_Slot(records.get(citizen_index));
                flag = false;
                hospital_index = i;
            }
        }

        if(flag){
            System.out.println("Please Enter Valid Hospital ID ");
            return;
        }
    }

    public void hospital_slots(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hospital Id: ");
        String hospital_id = sc.next();
        int pos = 0;
        for(int i=0;i<hospitals.size();i++){
            if(hospital_id.equals(hospitals.get(i).getUnique_id())){
                hospitals.get(i).print_slots();
            }
        }

    }

    public void vaccination_status(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        String unique_id = sc.next();
        int citizen_index = -1;
        boolean flag = true;
        for(int i=0;i<records.size();i++){
            if(unique_id.equals(records.get(i).getUnique_id())){
                flag = false;
                citizen_index = i;
                break;
            }
        }

        if(flag){
            System.out.println("Please register first on the covin portal");
            return;
        }

        records.get(citizen_index).print_Status();
    }

}