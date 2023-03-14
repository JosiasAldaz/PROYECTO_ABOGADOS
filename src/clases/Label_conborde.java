/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

/**
 *
 * @author LENOVO
 */
public class Label_conborde extends JLabel{

    public Label_conborde() {
        setText("");
        initComponent();
    }
    
    public Label_conborde(String info) {
        nombre = info;
        initComponent();
    }
    
    public Label_conborde(ImageIcon icon) {
        icono = icon;
        initComponent();
    }
    
    private void initComponent(){
        setText(nombre);
        setHorizontalAlignment(CENTER);
        setIcon(icono);
        setOpaque(true);
        setBorder(borde);
        setPreferredSize(new Dimension(300,300));
    }
    
    private String nombre = "";
    private ImageIcon icono = null; 
    private final Borde_label borde = new Borde_label();
}
