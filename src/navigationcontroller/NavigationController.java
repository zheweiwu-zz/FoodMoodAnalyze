/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationcontroller;

import mainmenuview.MainMenuView;

/**
 *
 * @author nadaziab
 */
public class NavigationController {
    
    private MainMenuView mainMenuView;
    
    public NavigationController() {
        
    }
    
    public void launchMainMenuView() {
        mainMenuView = new MainMenuView();
    }
    
    public MainMenuView getMainMenuView() {
        return mainMenuView;
    }
}
