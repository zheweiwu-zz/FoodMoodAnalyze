/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package historyview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
/**
 *
 * @author nadaziab
 */
public class HistoryView {
    
    public final JFrame f;
    private final JPanel p;
    
    private JScrollPane pane;
    
    private JButton backBtn;
    private JButton loadBtn;
    private JComboBox typeSelect;
    private JTable table;
    private final String[] labelsFood;
    private final String[] labelsMood;
    private final String [] type = {"Food", "Mood"};
    public Object [][] foodTableData = {{"Apple", "9/25", "11"}, {"Doughnut", "9/26", "12"}};
    public Object [][] moodTableData = {{"Sad", "12/10", "11"},{"Happy", "12/11", "1"}};
    
    public HistoryView() {
        this.labelsFood = new String[]{"Food", "Date", "Time"};
        this.labelsMood = new String[]{"Mood", "Date", "Time"};
    
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        
        f.setTitle("FoodMood Analytics - History");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        createComponents();
        
        f.add(p, BorderLayout.SOUTH);
        f.setVisible(false);
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        backBtn = new JButton("Back");
        loadBtn = new JButton("Load Table");
        
        typeSelect = new JComboBox(type);
        typeSelect.setSelectedIndex(1);
        setTable(this.getType());
        
        c.gridx = 0;
        c.gridy = 1;
        p.add(typeSelect, c);
        
        c.gridx = 0;
        c.gridy = 2;
        p.add(loadBtn, c);
        
        c.gridx = 0;
        c.gridy = 3;
        p.add(backBtn, c);
    }
    
    public JFrame getFrame() {
        return f;
    }
    public void rePaint(){
        f.remove(table);
        f.remove(pane);
        f.revalidate();
        f.repaint();
        this.setTable(getType());
        SwingUtilities.updateComponentTreeUI(f);
    }
    
    public JButton getLoadBtn(){
        return loadBtn;
    }
    public JButton getBackBtn() {
        return backBtn;
    }
    public String getType(){
        return (String) typeSelect.getSelectedItem();
    }
    
    public void setTable(String type)
    {
        if (type.equals("Food")){
            table = new JTable(foodTableData, labelsFood);
            pane = new JScrollPane(table);
            f.add(pane, BorderLayout.CENTER);
        }
        else {
            table = new JTable(moodTableData, labelsMood);
            pane = new JScrollPane(table);
            f.add(pane, BorderLayout.CENTER);
        }
    }
}
