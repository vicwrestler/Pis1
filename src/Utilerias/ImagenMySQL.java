/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author w-res
 */
public class ImagenMySQL extends javax.swing.JPanel{
    BufferedImage ruta;
    public ImagenMySQL(int x, int y, BufferedImage ruta){
        this.setSize(x, y);
        this.ruta=ruta;
    }
    public void paint(Graphics g){
        Dimension height=getSize();
        //ImageIcon img=new ImageIcon(getClass().getResource(ruta));
        BufferedImage img=ruta;
        g.drawImage(img, 0, 0, height.width, height.height, null);
        //g.drawImage(img, 0, 0, 300, 300, null)
        //g.drawImage(img, 0, 0, 150, 150, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
