/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author nadaziab
 */
public class ChartsView {
    
    private JFrame f;
    private JPanel p;
    
    private JButton backBtn;
    
    public ChartsView() {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("FoodMood Analytics - Charts");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        createComponents();
        
        f.add(p, BorderLayout.CENTER);
        f.setVisible(false);
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
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
