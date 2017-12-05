/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.List;
import MoodModel.MoodModel;
import FoodModel.FoodModel;

/**
 *
 * @author Alex
 */
public class Profile {
    
    private String name;
    private String password;
    private String username;
    private String weight;
    private List<FoodModel> foods;
    private List<MoodModel> moods;
}
