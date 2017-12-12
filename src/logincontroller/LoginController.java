/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logincontroller;

import DatabaseCntl.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
           
           try {
               // if authenticated
               if (Database.authProfile(lv.getUsername(), lv.getPassword())) {
                   String userID = lv.getUsername();
                   NavigationController nc = new NavigationController(userID);
                   nc.showMainMenu();
                   lv.getF().dispose();
               }
               else {
                   JOptionPane.showMessageDialog(lv.getF(), "The password combination is not correct.");
               }
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
       
    }
}
