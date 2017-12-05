/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseCntl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import User.Profile;

/**
 *
 * @author Alex
 */
public class DatabaseWrite {
    
    public static void writeProfile(String username, Profile profile) throws IOException{
        
    try {
    
    URL urlConnection = null;
        try {
            urlConnection = new URL("https://foodmood-a4f9d.firebaseio.com/profiles/" + username + ".json");
        } catch (MalformedURLException ex) {
            Logger.getLogger(DatabaseWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

            HttpURLConnection con = (HttpURLConnection) urlConnection.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException ex) {
            Logger.getLogger(DatabaseWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
        Gson gson = new GsonBuilder().create();
        gson.toJson(profile, osw);
            
            osw.flush();
            osw.close();
            
}
    catch(MalformedURLException e) {
            System.out.print("URL Malformed");
        }
}
}
