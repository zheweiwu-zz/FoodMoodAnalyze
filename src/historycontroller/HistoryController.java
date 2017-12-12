/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package historycontroller;

import DatabaseCntl.Database;
import historyview.HistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationcontroller.NavigationController;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import FoodModel.FoodModel;
import MoodModel.MoodModel;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nadaziab
 */
public class HistoryController implements ActionListener {
    
    private HistoryView historyView;
    private NavigationController navigationController;
    private ArrayList <FoodModel> foods;
    private ArrayList <MoodModel> moods;
    
    public HistoryController(NavigationController nc) throws ClassNotFoundException, SQLException {
        // needs 2 seperate methods to get all foods and moods
         foods = Database.getFoods();
         moods = Database.getMoods();
         
         Object[][] object = new Object[100][100];
         int i = 0;
            if (foods.size() != 0) {
                for (FoodModel food : foods) {
                    object[i][0] = food.getName();
                    object[i][1] = food.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
                    object[i][2] = food.getDateTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
                    
                    i++;
                }
                
         Object[][] object2 = new Object[100][100];
         int j = 0;
            if (moods.size() != 0) {
                for (MoodModel mood : moods) {
                    object[j][0] = mood.getDescription();
                    object[j][1] = mood.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
                    object[j][2] = mood.getDateTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
                    
                    i++;
                }       
                
        historyView = new HistoryView(object, object2);
        historyView.getBackBtn().addActionListener(this);
        historyView.getLoadBtn().addActionListener(this);
        navigationController = nc;
        
    }
            }
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

