/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author w-res
 */
public class prueba {
    JLabel titulo;
    JTextArea descripcion;
    JLabel costo;
    JPanel img;
    JButton boton;
    
    public prueba(){
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JTextArea getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(JTextArea descripcion) {
        this.descripcion = descripcion;
    }

    public JLabel getCosto() {
        return costo;
    }

    public void setCosto(JLabel costo) {
        this.costo = costo;
    }

    public JPanel getImg() {
        return img;
    }

    public void setImg(JPanel img) {
        this.img = img;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
    
}
