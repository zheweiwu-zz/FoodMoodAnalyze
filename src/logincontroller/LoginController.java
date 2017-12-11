/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logincontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loginview.LoginView;
import navigationcontroller.NavigationController;

/**
 *
 * @author nadaziab
 */
public class LoginController implements ActionListener {
    LoginView lv;
    
    public LoginController(LoginView lv) {
        this.lv = lv;
        this.lv.loginBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
       if (ae.getSource()==lv.loginBtn) {
           
           // if authenticated
           String userID = lv.getUsername();
           NavigationController nc = new NavigationController(userID);
           nc.showMainMenu();
           lv.getF().dispose();
           
           /*
            try {
                if (!lv.getUsername().equals("") && !lv.getPassword().equals("") && Database.authProfile(lv.getUsername(), lv.getPassword())) {
                    MainMenuView mmv = new MainMenuView();
                    String userID = lv.getUsername(); // get userid of person with username
                    NavigationController nc = new NavigationController(mmv, new FoodList(), new MoodList(), userID);
                    lv.getF().dispose();
                }
                else {
                    System.out.println("Error authenticating");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
           */
        }
       
    }
}
