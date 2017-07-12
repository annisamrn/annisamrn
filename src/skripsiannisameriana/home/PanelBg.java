/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.home;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author rpl-09
 */
public class PanelBg extends JPanel{
    
    private Image image;
    
    public PanelBg(){
        image = new ImageIcon(getClass().getResource("/skripsiannisameriana/picture/home.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        /**super.paintComponent(g);
        
        Graphics2D gd = (Graphics2D) g.create();
        
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        gd.dispose();**/
        BufferedImage bi = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gb = bi.createGraphics();
        gb.setPaint(Color.RED);
        gb.fillRect(0, 0, 400, 300);
        gb.dispose();

        // Set a rounded clipping region:
        RoundRectangle2D r = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        g.setClip(r);

        // Draw the rectangle (and see whether it has round corners)
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }  
}
