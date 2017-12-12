/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartscontroller;

import DatabaseCntl.Database;
import chartsview.ChartsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import navigationcontroller.NavigationController;
import javax.swing.JOptionPane;

/**
 *
 * @author nadaziab
 */
public class ChartsController implements ActionListener {
    
    private ChartsView chartsView;
    private NavigationController navigationController;
    
    public ChartsController(NavigationController nc) throws ClassNotFoundException, SQLException {
        // **** pass real data here
        chartsView = new ChartsView(Database.getCorrelations());
        chartsView.getBackBtn().addActionListener(this);
        chartsView.getNegativeBtn().addActionListener(this);
        chartsView.getNeutralBtn().addActionListener(this);
        chartsView.getPositiveBtn().addActionListener(this);
        navigationController = nc;
    }
    
    public void showChartsView() {
        chartsView.getFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chartsView.getBackBtn()) {
            navigationController.showMainMenu();
            chartsView.getFrame().dispose();
        }
    
        else if (e.getSource() == chartsView.getNegativeBtn()){
            chartsView.showFoods("neg");
        }
        else if (e.getSource() == chartsView.getNeutralBtn()){ 
            chartsView.showFoods("net");
        }
        else if (e.getSource() == chartsView.getPositiveBtn()){ 
            chartsView.showFoods("pos");
        }
    }
}
