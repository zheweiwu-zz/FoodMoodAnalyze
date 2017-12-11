/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        
        negativeBtn = new JButton("Negative Correlations");
        c.gridx = 0;
        c.gridy = 0;
        p.add(negativeBtn, c);
        
        neutralBtn = new JButton("Neutral Correlations");
        c.gridx = 1;
        c.gridy = 0;
        p.add(neutralBtn, c);
        
        positiveBtn = new JButton("Positive Correlations");
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
}
