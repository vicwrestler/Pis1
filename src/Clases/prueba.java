/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author w-res
 */
public class prueba {
    JLabel etiqueta;
    JButton boton;
    public prueba(String texto){
        etiqueta= new JLabel(texto);
        boton=new JButton("Agrega");
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(JLabel etiqueta) {
        this.etiqueta = etiqueta;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
}
