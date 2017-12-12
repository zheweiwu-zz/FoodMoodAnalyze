/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationcontroller;

import chartscontroller.ChartsController;
import correlationscontroller.CorrelationsController;
import historycontroller.HistoryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainmenuview.MainMenuView;

/**
 *
 * @author nadaziab
 */
public class NavigationController implements ActionListener {
    
    private MainMenuView mainMenuView;
    private HistoryController historyController;
    private CorrelationsController correlationsController;
    private ChartsController chartsController;
    
    private String userID;
    
    public NavigationController(String userID) {
        mainMenuView = new MainMenuView();
        this.userID = userID;
        addListeners();
    }
    
    public void showMainMenu() {
        mainMenuView.getFrame().setVisible(true);
    }
    
    public MainMenuView getMainMenuView() {
        return mainMenuView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainMenuView.getHistoryBtn()) {
            try {
                historyController = new HistoryController(this);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            historyController.showHistoryView();
            mainMenuView.getFrame().setVisible(false);
        }
        else if (e.getSource() == mainMenuView.getCorrelationsBtn()) {
            try {
                correlationsController = new CorrelationsController(this);
            } catch (SQLException ex) {
                Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            correlationsController.showCorrelationsView();
            mainMenuView.getFrame().setVisible(false);
        }
        else if (e.getSource() == mainMenuView.getChartsBtn()) {
            try {
                chartsController = new ChartsController(this);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            chartsController.showChartsView();
            mainMenuView.getFrame().setVisible(false);
        }
        
    }
    
    private void addListeners() {
        mainMenuView.getHistoryBtn().addActionListener(this);
        mainMenuView.getCorrelationsBtn().addActionListener(this);
        mainMenuView.getChartsBtn().addActionListener(this);
    }
}
