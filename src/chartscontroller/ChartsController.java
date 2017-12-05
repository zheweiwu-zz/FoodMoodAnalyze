/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartscontroller;

import chartsview.ChartsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationcontroller.NavigationController;

/**
 *
 * @author nadaziab
 */
public class ChartsController implements ActionListener {
    
    private ChartsView chartsView;
    private NavigationController navigationController;
    
    public ChartsController(NavigationController nc) {
        chartsView = new ChartsView();
        chartsView.getBackBtn().addActionListener(this);
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
    }
}
