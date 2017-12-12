/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correlationsview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nadaziab
 */
public class CorrelationsView {
    
    private JFrame f;
    private JPanel p;
    
    private final String[] correlationTypesArray = {"All Correlations", "Negative Correlations", "Neutral Correlations", "Positive Correlations"};
    private JComboBox correlationTypes;
    
    private JTable table;
    
    private JButton changeBtn, backBtn;
    
    private String[] correlations;
    
    public CorrelationsView(String[] c) {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("FoodMood Analytics - Correlations");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        correlations = c;
        
        createComponents();
        
        f.add(p, BorderLayout.SOUTH);
        f.setVisible(false);
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        
        ArrayList<String> negEntries = new ArrayList();
        ArrayList<String> neutEntries = new ArrayList();
        ArrayList<String> posEntries = new ArrayList();
        ArrayList<String> allEntries = new ArrayList();
                
        
        String negativeCorrelations = correlations[0];
        
        if (negativeCorrelations != null) {
            String[] negCorrData = negativeCorrelations.split(",");
            for (int i = 0; i < negCorrData.length; i++) {
                negEntries.add(negCorrData[i]);
                allEntries.add(negCorrData[i]);
            }
       }
        
        String neutralCorrelations = correlations[1];
        
        if (neutralCorrelations != null) {
            String[] neutCorrData = neutralCorrelations.split(",");
            for (int i = 0; i < neutCorrData.length; i++) {
                neutEntries.add(neutCorrData[i]);
                allEntries.add(neutCorrData[i]);
            }
        }
        
        String positiveCorrelations = correlations[2];
        
        if (positiveCorrelations != null) {
            String[] posCorrData = positiveCorrelations.split(",");
            for (int i = 0; i < posCorrData.length; i++) {
                posEntries.add(posCorrData[i]);
                allEntries.add(posCorrData[i]);
            }
        }
        
        Object[][] data = new Object[allEntries.size()][2];
        
        for (int i = 0; i < allEntries.size(); i++) {
            data[i][0] = allEntries.get(i);
            if (i < negEntries.size()) {
                data[i][1] = "Negative";
            }
            else if (i >= negEntries.size() && i < (negEntries.size() + posEntries.size())) {
                data[i][1] = "Neutral";
            }
            else if (i >= (negEntries.size() + neutEntries.size())) {
                data[i][1] = "Positive";
            }
        }

        String[] column = {"Food", "Correlation"};
        
        table = new JTable(data, column);
        table.setAutoCreateRowSorter(true);
        
        JScrollPane pane = new JScrollPane(table);
        f.add(pane);
        
        
        
        backBtn = new JButton("Back");
        c.gridx = 0;
        c.gridy = 0;
        p.add(backBtn, c);
    }
    
    public JFrame getFrame() {
        return f;
    }
    
    public JButton getBackBtn() {
        return backBtn;
    }
}
