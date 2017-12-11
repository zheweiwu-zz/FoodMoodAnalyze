/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseCntl;
//import com.google.gson.Gson.*;
//import com.google.gson.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import User.Profile;

/**
 *
 * @author Alex
 */
public class DatabaseRead {
    
    public static void readProfile(String username){
    
    
    /*
    String url = "https://foodmood-a4f9d.firebaseio.com/profiles/" + username + "/.json";
    try {
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            Gson gson = new Gson();
            gson.fromJson(in, Profile.class);

            //System.out.println(inputLine);//testline
        } catch (Exception e) {
            e.printStackTrace();
    }
            */
    }
}
