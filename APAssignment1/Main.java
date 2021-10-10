//Name: Nakul Thureja
//Roll No: 2020528
//AP Assignment 1
package APAssignment1;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.*;


public class Main {

    public static void main(String[] args) {
	System.out.println("Covin Portal initialized....");
        Covin covin = new Covin();
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("--------------------------------- ");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen ");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            System.out.println("Enter Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1: covin.Add_Vaccine();
                    break;
                case 2: covin.Add_Hospital();
                    break;
                case 3: covin.Add_Citizen();
                    break;
                case 4: covin.Add_slot();
                    break;
                case 5: covin.book_slot();
                    break;
                case 6: covin.hospital_slots();
                    break;
                case 7: covin.vaccination_status();
                    break;
                case 8: System.out.println("Exited.....");
                    System.exit(0);
                default:System.out.println("Please Enter valid input...");
            }
        }
    }
}
