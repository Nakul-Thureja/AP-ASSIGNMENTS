
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.*;

public class Citizens{
     private String name;
     private int age;
     private String unique_id;

    Citizens(String name,int age,String unique_id){
        this.name = name;
        this.age = age;
        this.unique_id = unique_id;

    }

    public String getName(){
        return this.name;
    }

    public String getUnique_id(){
        return this.unique_id;
    }

    public String toString(){
        return ("Citizen Name: "+this.name +" Age: "+ this.age
                +" Unique ID: "+this.unique_id);
    }
}