/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package historycontroller;

import historyview.HistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationcontroller.NavigationController;
import javax.swing.SwingUtilities;

/**
 *
 * @author nadaziab
 */
public class HistoryController implements ActionListener {
    
    private HistoryView historyView;
    private NavigationController navigationController;
    
    public HistoryController(NavigationController nc) {
        // needs 2 seperate methods to get all foods and moods
        //Object [][] foods = Database.getfoodsorsomething()
        historyView = new HistoryView(null, null);
        historyView.getBackBtn().addActionListener(this);
        historyView.getLoadBtn().addActionListener(this);
        navigationController = nc;
        
    }
    
    public void showHistoryView() {
        historyView.getFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == historyView.getBackBtn()) {
            navigationController.showMainMenu();
            historyView.getFrame().dispose();
        }
        else if (e.getSource() == historyView.getLoadBtn()){
            historyView.rePaint();  
        }
        }
    }

