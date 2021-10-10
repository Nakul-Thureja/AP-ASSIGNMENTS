
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.*;

public class vaccine{
    private String vaccine_name;
    private int doses;
    private int gap;

    vaccine(String vaccine_name,int doses,int gap){
        this.vaccine_name = vaccine_name;
        this.doses = doses;
        this.gap = gap;
    }

    public String toString(){
        return ("Vaccine Name: " + this.vaccine_name + ", Number of Doses:" +
                this.doses +  ", Gap Between Doses:" + this.gap);
    }

    public String getVaccine_name() {
        return this.vaccine_name;
    }

    public int getGap() {
        return this.gap;
    }

    public int getDoses(){
        return this.doses;
    }
 }
