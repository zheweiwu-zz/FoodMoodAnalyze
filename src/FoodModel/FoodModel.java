/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodModel;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Zhewei
 */
public class FoodModel {
    
    private String name;
    private LocalDateTime consumedAtDT;
    private String consumedAt;
    private String foodID;
    private Random random;
    private String parentUserID;
    
    public FoodModel() {
        System.out.println("FoodModel instantiated");
    }
    
    public FoodModel(String name, String userID) {
        this.name = name;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hhmmssddmmyyyy");
        this.consumedAtDT = LocalDateTime.now();
        this.consumedAt = dtf.format(consumedAtDT);
        //random = new Random();
        this.foodID = this.name+consumedAt;
        //this.parentUserID = Database.username;
    }
    
    public FoodModel(String name, LocalDateTime date, String foodID) {
        this.name = name;
        this.consumedAtDT = date;
        this.foodID = foodID;
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public LocalDateTime getDateTime() {
        return consumedAtDT.truncatedTo(ChronoUnit.SECONDS);
    }
    
    
    public void setDate(LocalDateTime dateTime) {
        this.consumedAtDT = dateTime;
    }
    
    public String getInfo() {
        return name+" "+consumedAt+" "+foodID;
    }
    
    public String getID() {
        return foodID;
    }
    
    public String getParentUserID(){
        return parentUserID;
    }
    
}
