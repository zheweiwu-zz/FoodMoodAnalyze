/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodMoodAnalyze;

import logincontroller.LoginController;
import loginview.LoginView;
import navigationcontroller.NavigationController;

/**
 *
 * @author zheweiwu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("start app");
        LoginView loginView = new LoginView();
        LoginController loginCntl = new LoginController(loginView);
    }
    
}
