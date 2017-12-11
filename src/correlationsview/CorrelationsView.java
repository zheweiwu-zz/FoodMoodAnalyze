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
    
    public CorrelationsView() {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("FoodMood Analytics - Correlations");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        createComponents();
        
        f.add(p, BorderLayout.NORTH);
        f.setVisible(false);
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        correlationTypes = new JComboBox(correlationTypesArray);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        p.add(correlationTypes);
        
        
        String[][] data = {{"Apple", "4", "Positive"}};
        String[] column = {"FOOD", "MOOD RATING", "CORRELATION"};
        
        table = new JTable(data, column);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        
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
