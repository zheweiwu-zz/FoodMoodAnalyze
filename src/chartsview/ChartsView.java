/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsview;

import DatabaseCntl.Database;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.Arrays;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;

/**
 *
 * @author nadaziab
 */
public class ChartsView {
    
    private JFrame f;
    private JPanel p;
    
    private JButton negativeBtn, neutralBtn, positiveBtn, backBtn;
    
    private int[] data;
    
    public ChartsView(int[] data) {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("FoodMood Analytics - Charts");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        
        this.data = data;
        
        createComponents();
        
        //f.add(p, BorderLayout.CENTER);
        f.setVisible(false);
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        negativeBtn = new JButton("Negative Foods");
        c.gridx = 0;
        c.gridy = 0;
        p.add(negativeBtn, c);
        
        neutralBtn = new JButton("Neutral Foods");
        c.gridx = 1;
        c.gridy = 0;
        p.add(neutralBtn, c);
        
        positiveBtn = new JButton("Positive Foods");
        c.gridx = 2;
        c.gridy = 0;
        p.add(positiveBtn, c);
        
        backBtn = new JButton("Back");
        c.gridx = 1;
        c.gridy = 1;
        p.add(backBtn, c);
        
        ChartPanel chart = new ChartPanel(data);
        f.add(chart, BorderLayout.CENTER);
        f.add(p, BorderLayout.SOUTH);
    }
    
    public JFrame getFrame() {
        return f;
    }
    
    public JButton getBackBtn() {
        return backBtn;
    }
    
    public JButton getNegativeBtn() {
        return negativeBtn;
    }
    
    public JButton getNeutralBtn() {
        return neutralBtn;
    }
    
    public JButton getPositiveBtn() {
        return positiveBtn;
    }
    public void showFoods(String a) throws SQLException, ClassNotFoundException
    {
    if (a.equals("neg")){          
    JOptionPane.showMessageDialog(f, removeLastChar(Database.getAssociatedFood()[0]));
    }
    else if (a.equals("net")){
    JOptionPane.showMessageDialog(f, removeLastChar(Database.getAssociatedFood()[1]));
    }
    else if (a.equals("pos")){
    JOptionPane.showMessageDialog(f, removeLastChar(Database.getAssociatedFood()[2]));
    //System.out.print(Database.getAssociatedFood()[2]);
    }
    }
    
    private static String removeLastChar(String str) {
        if (str != null && str.length() > 0){
    return str.substring(0, str.length() - 1);
        }
        else{ return "";}
}
}
