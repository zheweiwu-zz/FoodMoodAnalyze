/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoodModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Zhewei
 */
public class MoodModel{
    
    private String description;
    private LocalDateTime recordedAtDT;
    private String recordedAt;
    private String moodID;
    private String userID;
   //private Random random;
    private String parentFoodID;
    private int moodRating;
    
    public MoodModel(int rating) {
        this.moodRating = rating;
        this.recordedAtDT = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hhmmssddmmyyyy");
        this.recordedAt = dtf.format(recordedAtDT);
        //this.parentFoodID = Database.lastFoodID;
        this.moodID = this.userID + recordedAt;
    }
    
    public MoodModel(int rating, LocalDateTime recordedAt, String moodID) {
        this.moodRating = rating;
        this.recordedAtDT = recordedAt;
        this.moodID = moodID;
    }
    
    public String getUserID()
    {
        return userID;
    }
    

    public String getDescription() {
        return this.description;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }
    

    public LocalDateTime getDateTime() {
        return recordedAtDT.truncatedTo(ChronoUnit.SECONDS);
    }
    

    public void setDate(LocalDateTime dateTime) {
        this.recordedAtDT = dateTime;
    }
    /**
     * Get the information at index
     * @param index index of retrieval
     * @return information at the index
     */
    public String getInfo(String index) {
        return description + " " + recordedAt+" "+moodID;
    }
    
    public String getID()
    {
        return moodID;
    }



    /**
     * @return the parentFoodID
     */
    public String getParentFoodID() {
        return parentFoodID;
    }

    /**
     * @return the moodRating
     */
    public int getMoodRating() {
        return moodRating;
    }

    @Override
    public String toString() {
        return "MoodModel{" + "description=" + description + ", recordedAtDT=" + recordedAtDT + ", recordedAt=" + recordedAt + ", moodID=" + moodID + ", userID=" + userID + ", parentFoodID=" + parentFoodID + ", moodRating=" + getMoodRating() + '}';
    }

}
