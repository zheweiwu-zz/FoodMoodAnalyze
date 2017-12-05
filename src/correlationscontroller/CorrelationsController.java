/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correlationscontroller;

import correlationsview.CorrelationsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationcontroller.NavigationController;

/**
 *
 * @author nadaziab
 */
public class CorrelationsController implements ActionListener {
    
    CorrelationsView correlationsView;
    private NavigationController navigationController;
    
    public CorrelationsController(NavigationController nc) {
        correlationsView = new CorrelationsView();
        correlationsView.getBackBtn().addActionListener(this);
        navigationController = nc;
    }
    
    public void showCorrelationsView() {
        correlationsView.getFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == correlationsView.getBackBtn()) {
            navigationController.showMainMenu();
            correlationsView.getFrame().dispose();
        }
    }
}
