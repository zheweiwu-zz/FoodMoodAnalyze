/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author nadaziab
 */
public class ChartPanel extends JPanel {
    
    private int[] data; // [0] = negative, [1] = neutral, [2] = positive
    private String[] names; 
    private String title;
    
    public ChartPanel(int[] data) {
        //values = v;
        //names = n;
        //title = t;
        
        // *** test data ***
        this.data = new int[3];
        this.data[0] = 5;
        this.data[1] = 3;
        this.data[2] = 4;
        
        names = new String[3];
        names[0] = "Negative";
        names[1] = "Neutral";
        names[2] = "Positive";
        
        //******
        
        title = "Food - Mood Correlations";
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int min = 0;
        int max = 0;
        
        
        for (int i = 0; i < data.length; i++) {
            if (min > data[i])
                min = data[i];
            if (max < data[i])
                max = data[i];
        }

        Dimension dimension = getSize();
        
        int totalWidth = dimension.width;
        int totalHeight = dimension.height;
        int barWidth = totalWidth / data.length;

        Font titleF = new Font("Courier", Font.BOLD, 20);
        FontMetrics titleFMet = g.getFontMetrics(titleF);
        Font labelF = new Font("Courier", Font.PLAIN, 10);
        FontMetrics labelFMet = g.getFontMetrics(labelF);

        int titleWidth = titleFMet.stringWidth(title);
        int y = titleFMet.getAscent();
        int x = (totalWidth - titleWidth) / 2;
        g.setFont(titleF);
        g.drawString(title, x, y);

        int top = titleFMet.getHeight();
        int bottom = labelFMet.getHeight();
        
        int scale = (totalHeight - top - bottom) / (max - min);
        y = totalHeight - labelFMet.getDescent();
        g.setFont(labelF);

        for (int i = 0; i < data.length; i++) {
            int xVal = i * barWidth + 1;
            int yVal = top;
            
            int height = (int) (data[i] * scale);
            
            if (data[i] >= 0)
                yVal += (int) ((max - data[i]) * scale);
            else {
                yVal += (int) (max * scale);
                height = -height;
            }

            if (i == 0) {
                g.setColor(Color.RED);
            }
            else if (i == 1) {
                g.setColor(Color.YELLOW);
            }
            else if (i == 2) {
                g.setColor(Color.GREEN);
            }
            
            g.fillRect(xVal, yVal, barWidth - 2, height);
            g.setColor(Color.black);
            g.drawRect(xVal, yVal, barWidth - 2, height);
            int labelWidth = labelFMet.stringWidth(names[i]);
            x = i * barWidth + (barWidth - labelWidth) / 2;
            g.drawString(names[i], x, y);
        }
    }
}
