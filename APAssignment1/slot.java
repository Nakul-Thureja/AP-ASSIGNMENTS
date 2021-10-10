
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.*;

public class slot{
    private int day;
    private Hospital hospital;
    private vaccine vac;

    slot(int day,vaccine vac){
        this.day = day;
        this.hospital = null;
        this.vac = vac;
    }

    public void setHospital(Hospital hospital){
        this.hospital = hospital;
    }

    public int getDay(){
        return this.day;
    }

    public int getDoses(){
        return this.vac.getDoses();
    }

    public int getnextDose(){ return this.vac.getGap() + this.day; }

    public int getGap() {
        return this.vac.getGap();
    }

    public String getVac() {
        return this.vac.getVaccine_name();
    }
}
