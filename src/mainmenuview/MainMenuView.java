/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenuview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author nadaziab
 */
public class MainMenuView {
    
    private JFrame f;
    private JPanel p;
    
    private JButton historyBtn, correlationsBtn, chartsBtn;
    
    public MainMenuView() {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("FoodMood Analytics");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        createComponents();
        
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        historyBtn = new JButton("Food/Mood History");
        c.gridx = 0;
        c.gridy = 0;
        p.add(historyBtn, c);
        
        correlationsBtn = new JButton("Food/Mood Correlations");
        c.gridx = 0;
        c.gridy = 1;
        p.add(correlationsBtn, c);
        
        chartsBtn = new JButton("Food/Mood Charts");
        c.gridx = 0;
        c.gridy = 2;
        p.add(chartsBtn, c);
        
    }
    
    public JButton getHistoryBtn() {
        return historyBtn;
    }
    
    public JButton getCorrelationsBtn() {
        return correlationsBtn;
    }
    
    public JButton getChartsBtn() {
        return chartsBtn;
    }
    
    public JFrame getFrame() {
        return f;
    }
}
